package converter.instruction;

import converter.ScoreComponent;

public class TimeSignature extends Instruction {
    TimeSignature(String line, int position, RelativePosition relativePosition) {
        super(line, position, relativePosition);
    }

    @Override
    public void apply(ScoreComponent scoreComponent) {

    }
}