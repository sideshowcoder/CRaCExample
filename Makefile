container:
	mvn package
	docker build -t crac_example .

run:
	docker run -it --cap-add=CHECKPOINT_RESTORE --cap-add=SYS_PTRACE --rm --name crac_example \
    -v ./crac-files:/opt/crac-files crac_example \
    java -XX:CRaCCheckpointTo=/opt/crac-files -XX:+CRaCImageCompression -jar /opt/app/crac-example.jar || true

checkpoint:
	docker exec crac_example jcmd /opt/app/crac-example.jar JDK.checkpoint

container-restore:
	docker build -t crac_example_restore -f Dockerfile.restore .

run-restore:
	docker run -it --rm crac_example_restore \
	java -XX:CRaCRestoreFrom=/opt/crac-files

clean:
	mvn clean
	rm -rf ./crac-files
	docker rmi crac_example
	docker rmi crac_example_restore
