// DO NOT INCLUDE THIS IMPORT WHEN SENT FOR GRADING, THIS IS HERE TO HELP YOU DEBUG THE PROGRAM STATE
import java.util.Arrays;

public class SystemWhole {
    public static String[] emergences; // To store JSON strings representing emergences
    public static Machine[] parts; // To store Machine objects directly as an array

    public static void main(String[] args) {
//         Sample JSON strings representing different "emergences"
        String[] emergences = {
                "{\"kind\": \"Humanoid\", \"bodyType\": \"\", \"faceType\": \"23..34..\", \"reverie\": \"anthropomorphic\"}",
                "{\"kind\": \"Humanoid\", \"bodyType\": \".\", \"faceType\": \"5.5\", \"reverie\": \"anthropomorphic23\"}",
        };


//         Parse the emergences and set them to the SystemWhole state
        emergencesFromPhenomena(emergences);
        // Analyze the shapes based on the set emergences
        reifyFrameOfReference();
        System.out.println("Prelude of the Rise of the Machines: " + Arrays.deepToString(parts));
        System.out.println("Prelude of the Rise of the Machines: [Machine{kind=Humanoid, humanoid=false, properties=[PartState{bodyType=physical}, PartState{faceType=anthropomorphic}, PartState{reverie=mechatypical}]}, Machine{kind=Humanoid, humanoid=true, properties=[PartState{bodyType=physical}, PartState{faceType=anthropomorphic}, PartState{reverie=biotypical}]}, Machine{kind=Robot, humanoid=true, properties=[PartState{bodyType=physical}, PartState{faceType=anthropomorphic}, PartState{reverie=biotypical}]}, Machine{kind=Robot, humanoid=false, properties=[PartState{material=metal}, PartState{function=industrial}]}, Machine{kind=Humanoid, humanoid=false, properties=[PartState{bodyType=physical}, PartState{faceType=anthropomorphic}]}, Machine{kind=27.82, humanoid=false, properties=[PartState{bodyType=299U2}, PartState{faceType=252}, PartState{reverie=2525}]}]".equals("Prelude of the Rise of the Machines: " + Arrays.deepToString(parts)));
        parts[0].emergeFromLimitations();
        // Track humanoid machines and identify singularities
        Machine[] singularities = trackSingularityMachines();
        System.out.println("Singularities: " + Arrays.deepToString(singularities));
    }

    public static void emergencesFromPhenomena(String[] emergences) {
        //Saves the provided JSON strings into the emergences field.
        SystemWhole.emergences = emergences;
    }

    public static void reifyFrameOfReference() {
        SystemWhole.parts = new Machine[emergences.length];
        int i = 0;
        for (String emergence : emergences) {
            //put each string into ShapeAnalyzer.analyze to divide "kind" and "properties"
            SystemWhole.parts[i++] = ShapeAnalyzer.analyze(emergence);
        }
    }

    public static boolean isHumanoid(Object[] machineProperties) {
//        Object[][] splitMachineProperties = new String[machineProperties.length][];
//        for (int i = 0; i < splitMachineProperties.length;i++) {
//            splitMachineProperties[i] = new String[2];
//            String[] miniSplitMachineProperties = ((machineProperties[i]).split("=",0));
//
//        }
        int f = 0;
        for (int i = 0; i < machineProperties.length; i++) {
            String properties = machineProperties[i].toString();
            if ((properties.contains("bodyType")) && ((properties.contains("physical")))) {
                f += 1;
            }
            if ((properties.contains("faceType")) && ((properties.contains("anthropomorphic")))) {
                f += 1;
            }
            if ((properties.contains("reverie")) && ((properties.contains("biotypical")))) {
                f += 1;
            }
        }
        if (f == 3) {
            return true;
        }
        return false;
    }

    // SystemWhole's logic to determine if a Machine is humanoid and count them
    public static int identitySingularityMachines() {
        Machine[] singularityMachinesArray = trackSingularityMachines();
        int j = 0;
        for (Machine object : singularityMachinesArray) {
            j++;
        }
        return j;
    }

    public static Machine[] trackSingularityMachines() {
        //@return Machine object array containing the machines that have at leastsingularity

        int j = 0;
        for (int i = 0; i < SystemWhole.parts.length; i++) {
            //find the length of the machineWithSingularity array
            Object[] propertiesGetter = SystemWhole.parts[i].getProperties();//get the properties objects from ShapeAnalyzer
            boolean machineThinkingHumanoid = SystemWhole.parts[i].isHumanoid();//@return machine thinking for humanoid
            boolean systemCheckHumanoid = isHumanoid(propertiesGetter); //@return system check for humanoid
            if (!(machineThinkingHumanoid && systemCheckHumanoid))  {
                j++;
            }
        }
        int f = 0;
        Machine[] machineWithSingularity = new Machine[j];
        for (int i = 0; i < SystemWhole.parts.length; i++) {
            // return the array
            Object[] propertiesGetter = SystemWhole.parts[i].getProperties();//get the properties objects from ShapeAnalyzer
            boolean machineThinkingHumanoid = SystemWhole.parts[i].isHumanoid();//@return machine thinking for humanoid
            boolean systemCheckHumanoid = isHumanoid(propertiesGetter); //@return system check for humanoid
            if (!(machineThinkingHumanoid && systemCheckHumanoid)) {
                machineWithSingularity[f++] = SystemWhole.parts[i];

            }

        }
        return machineWithSingularity;

    }

}
