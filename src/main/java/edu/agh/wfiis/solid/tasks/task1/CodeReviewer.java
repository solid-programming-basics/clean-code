package edu.agh.wfiis.solid.tasks.task1;

import java.util.Map;
import java.util.function.BiConsumer;

final class CodeReviewer {
    private static final int BAD_POINTS = -10;
    private static final int GOOD_POINTS = 20;
    private static final int EXCELLENT_POINTS = 30;
    private static final int FANTASTIC_POINTS = 50;

    private static final Map<String, BiConsumer<Identifiable, SolidPoints>> POINTS_MODIFICATIONS_BY_CODE_QUALITY = Map.of(
            "bad", (reviewer, solidPoints) -> {
                solidPoints.subtractPoints(-BAD_POINTS);
                System.out.println("Reviewer "+ reviewer.identify() + " sadly has to subtract " + -BAD_POINTS +" pts from " + solidPoints.getOwnerIdentity() + " account" );
            },
            "good", (reviewer, solidPoints) -> {
                solidPoints.earnPoints(GOOD_POINTS);
                System.out.println("Reviewer "+ reviewer.identify() + " happily adds " + GOOD_POINTS +" pts to " + solidPoints.getOwnerIdentity() + " account" );
            },
            "excellent", (reviewer, solidPoints) -> {
                solidPoints.earnPoints(EXCELLENT_POINTS);
                System.out.println("Reviewer "+ reviewer.identify() + " is really happy to add " + EXCELLENT_POINTS +" pts to " + solidPoints.getOwnerIdentity() + " account for excellent code" );
            },
            "fantastic", (reviewer, solidPoints) -> {
                solidPoints.earnPoints(FANTASTIC_POINTS);
                System.out.println("Reviewer "+ reviewer.identify() + " is delighted to add  " + FANTASTIC_POINTS +" pts to " + solidPoints.getOwnerIdentity() + " account for fantastic code" );
            }
    );

    private final Identifiable reviewer;

    public CodeReviewer(Identifiable reviewer) {
        this.reviewer = reviewer;
    }

    public void reviewCode(String codeQuality, SolidPoints solidPoints) {
        BiConsumer<Identifiable, SolidPoints> modification = POINTS_MODIFICATIONS_BY_CODE_QUALITY.get(codeQuality);
        if (modification != null) {
            modification.accept(reviewer, solidPoints);
        } else {
            System.out.println("Reviewer " + reviewer.identify() +" cannot review the code for " + solidPoints.getOwnerIdentity()  + " because of unknown code quality:" + codeQuality);
        }
    }
}
