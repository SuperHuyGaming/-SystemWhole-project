public class Machine {
    private final Object kind; // Type of shape as Object
    private final Object[] properties; // Properties of the shape as an array of Object
    private final boolean humanConstrained; // Stores the result of the humanoid check
    private boolean humanEmergence; // Stores the result of the humanoid check

    public Machine(Object kind, Object[] partStates, boolean humanConstrained) {
        this.kind = kind;
        this.properties = partStates;
        this.humanConstrained = humanConstrained;

    }

    public Object[] getProperties() {
        return properties;
    }

    public void emergeFromLimitations() {
        this.humanEmergence = true;
    }

    public boolean isHumanoid() {
        return (humanConstrained || this.humanEmergence);
    }

    @Override
    public String toString() {
        return String.format("Machine{kind=%s, humanoid=%s, properties=%s}", kind, humanConstrained,
                propertiesToString(properties));
    }

    public static String propertiesToString(Object[] machineProperties) {
        StringBuilder concatStringProperties = new StringBuilder();
        concatStringProperties.append("[");
        for (int i = 0; i < machineProperties.length - 1; i++) {
            //convert the machineProperties elements to string
            String properties = machineProperties[i].toString();
            // concat the properties with "," into the string
            concatStringProperties.append(properties).append(", ");
        }
        //Concatenate the last element without a trailing ","
        concatStringProperties.append(machineProperties[machineProperties.length - 1].toString());
        concatStringProperties.append("]");
        return concatStringProperties.toString();
    }
}
