public class LibraryMembershipSystem {
    public static void main(String[] args) {
        LibraryMember[] members = {
            new StudentMember("Riya", "STU1001"),
            new FacultyMember("Dr. Sharma", "FAC2001"),
            new GuestMember("Amit", "GST3001")
        };

        for (LibraryMember member : members) {
            member.printMemberDetails();
            System.out.println("Fine for 7 overdue days: " + member.calculateFine(7));
        }

        String searchId = "FAC2001";
        LibraryMember found = findMemberById(members, searchId);
        if (found != null) {
            System.out.println("Member found: " + found.getMemberName() + " (" + found.getMemberId() + ")");
        } else {
            System.out.println("Member with ID " + searchId + " not found.");
        }
    }

    public static LibraryMember findMemberById(LibraryMember[] members, String memberId) {
        for (LibraryMember member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
}

abstract class LibraryMember {
    private String memberName;
    private String memberId;

    public LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void printMemberDetails() {
        System.out.println("Member Name: " + memberName);
        System.out.println("Member ID: " + memberId);
        System.out.println("Type: " + this.getClass().getSimpleName());
    }

    public abstract double calculateFine(int overdueDays);
}

class StudentMember extends LibraryMember {
    public StudentMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 1.0;
    }
}

class FacultyMember extends LibraryMember {
    public FacultyMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 0.5;
    }
}

class GuestMember extends LibraryMember {
    public GuestMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 2.0;
    }
}
