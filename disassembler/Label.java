package disassembler;

public class Label {
    private int indexDetected;

    // Distance from Index Detected
    private int labelDistance;

    /**
     * @param indexDetected
     */
    public void setIndexDetected(int indexDetected) {
        this.indexDetected = indexDetected;
    }

    /**
     * @param labelDistance
     */
    public void setLabelDistance(int labelDistance) {
        this.labelDistance = labelDistance;
    }

    /**
     * @return int
     */
    public int getIndexDetected() {
        return indexDetected;
    }

    /**
     * @return int
     */
    public int getLabelDistance() {
        return labelDistance;
    }

    public Label(int indexDetected, int labelDistance) {
        this.indexDetected = indexDetected;
        this.labelDistance = labelDistance;
    }

}
