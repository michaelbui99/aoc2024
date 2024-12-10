package dk.michaelbui.aoc2024.models.report;

public class ReportBuilder {
    private String levels;
    private Dampener dampener = null;

    public ReportBuilder(String levels) {
        this.levels = levels;
    }

    public ReportBuilder withDampener() {
        this.dampener = new Dampener();
        return this;
    }

    public Report build() {
        if (dampener == null) {
            return new Report(levels);
        }

        return new Report(levels, dampener);
    }
}
