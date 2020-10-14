package me.domirusz24.bq.bqmoonstage.bqmoonstage;


import pl.betoncraft.betonquest.Instruction;
import pl.betoncraft.betonquest.InstructionParseException;
import pl.betoncraft.betonquest.QuestRuntimeException;
import pl.betoncraft.betonquest.api.Condition;
import pl.betoncraft.betonquest.utils.PlayerConverter;

public class MoonStage extends Condition {

    int moonstage;

    public MoonStage(Instruction instruction) throws InstructionParseException {
        super(instruction);
        String stageString = instruction.next();
        int stage;
        try {
            stage = Integer.parseInt(stageString);
        } catch (NumberFormatException e) {
            throw new InstructionParseException("MoonStage value is not valid.");
        }
        if (stage < 0 || stage > 7) {
            throw new InstructionParseException("MoonStage value is not valid.");
        }
        moonstage = stage;
    }

        /*
         0 == FullMoon
         1 == 3/4
         2 == 2/4
         3 == 1/4
         4 == NewMoon
         5 == 1/4
         6 == 2/4
         7 == 3/4
        */

    @Override
    public boolean check(String s) throws QuestRuntimeException {
        float days = (float) PlayerConverter.getPlayer(s).getWorld().getFullTime()/24000;
        int phase = (int) days % 8;
        return phase == moonstage;
    }
}
