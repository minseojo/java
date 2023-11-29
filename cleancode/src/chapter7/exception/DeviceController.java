package chapter7.exception;

public class DeviceController {
    ...

    public void sendShutDown() {
        try {
            tryToShutDown();
        }
        catch (DeviceShutDownError e) {
            logger.log(e);
        }
    }

    private void tryToShutDown() {
        DeviceHandle handle = getHandle(DEV1);
        DeviceRecord record = retrieveDeviceRecord(handle);

        pauseDevice(handle);
        clearDeviceWorkQueue(handle);
        closeDevice(handle);
    }

    private DeviceHandle getHandle(DeviceId id) {
		...
        throw new DeviceShutDownError("Invalid handle for: " + id.toString());
		...
    }

    private DeviceRecord retrieveDeviceRecord(DeviceHandle handle) {
		...
        throw new DeviceShutDownError("Invalid handle for: " + handle.toString());
		...
    }
}
