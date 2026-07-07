public class DisasterRescueManagementSystem {
    public static void main(String[] args) {
        RescueTeam[] teams = {
            new MedicalTeam("MED-001", "Zone A"),
            new FireRescueTeam("FIR-101", "Zone B"),
            new FoodSupplyTeam("FOOD-301", "Zone A"),
            new FireRescueTeam("FIR-102", "Zone C")
        };

        performAllDuties(teams);
        countTeamsByCategory(teams);
        displayTeamsByPrefix(teams, "FIR");
        RescueTeam[] found = findTeamByLocation(teams, "Zone A");
        System.out.println("Teams in Zone A: " + found.length);
    }

    public static void performAllDuties(RescueTeam[] teams) {
        for (RescueTeam team : teams) {
            team.performDuty();
        }
    }

    public static RescueTeam[] findTeamByLocation(RescueTeam[] teams, String location) {
        return java.util.Arrays.stream(teams)
                .filter(team -> team.getLocation().equals(location))
                .toArray(RescueTeam[]::new);
    }

    public static void displayTeamsByPrefix(RescueTeam[] teams, String prefix) {
        for (RescueTeam team : teams) {
            if (team.getTeamId().startsWith(prefix)) {
                System.out.println("Team: " + team.getTeamId() + " in " + team.getLocation());
            }
        }
    }

    public static void countTeamsByCategory(RescueTeam[] teams) {
        int medical = 0, fire = 0, food = 0;
        for (RescueTeam team : teams) {
            if (team instanceof MedicalTeam) medical++;
            if (team instanceof FireRescueTeam) fire++;
            if (team instanceof FoodSupplyTeam) food++;
        }
        System.out.println("Medical: " + medical + ", Fire: " + fire + ", Food: " + food);
    }
}

abstract class RescueTeam {
    private String teamId;
    private String location;

    public RescueTeam(String teamId, String location) {
        this.teamId = teamId;
        this.location = location;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getLocation() {
        return location;
    }

    public abstract void performDuty();
}

class MedicalTeam extends RescueTeam {
    public MedicalTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println(getTeamId() + " provides medical aid in " + getLocation());
    }
}

class FireRescueTeam extends RescueTeam {
    public FireRescueTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println(getTeamId() + " extinguishes fire in " + getLocation());
    }
}

class FoodSupplyTeam extends RescueTeam {
    public FoodSupplyTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println(getTeamId() + " distributes food in " + getLocation());
    }
}
