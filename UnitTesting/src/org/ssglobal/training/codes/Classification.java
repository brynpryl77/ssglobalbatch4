package org.ssglobal.training.codes;

public enum Classification {
    EXCELLENT, VERY_SATISFACTORY, SATISFACTORY, PASS, FAIL;

    public static Classification evaluate(int score) {
        if (score >= 95) {
            return EXCELLENT;
        } else if ((score >= 90) && (score < 95)) {
            return VERY_SATISFACTORY;
        } else if ((score >= 80) && (score < 90)) {
            return SATISFACTORY;
        } else if ((score >= 70) && (score < 80)) {
            return SATISFACTORY;
        } else {
            return FAIL;
        }
    }

    public static double computeWeights(Classification classification) {
        double weight = 0.0;
        switch (classification) {
            case EXCELLENT:
                weight = 100.0;
                break;
            case VERY_SATISFACTORY:
                weight = 90.0;
                break;
            case SATISFACTORY:
                weight = 80.0;
                break;
            default:
                weight = 50.0;
                break;
        }
        return weight;
    }
}
