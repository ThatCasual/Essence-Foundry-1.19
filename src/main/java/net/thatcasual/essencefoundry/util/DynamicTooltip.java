package net.thatcasual.essencefoundry.util;

import net.minecraft.text.MutableText;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DynamicTooltip {

    public List<MutableText> fulltip = new ArrayList<MutableText>();

    //Constructor for a single line of text on item registration.
    public DynamicTooltip(@Nullable MutableText text) {
        if (text != null){
            fulltip.add(text);
        }
    }

    //Constructor for multiple lines of text on item registration.
    public DynamicTooltip(@Nullable List<MutableText> textlist) {
        if(textlist != null) {
            for (int i = 0; i < textlist.size(); i++) {
                if (textlist.get(i) != null) {
                    fulltip.add(textlist.get(i));
                }
            }
        }
    }

    //Adds text to the end of the tooltip.
    public void addToTooltip(MutableText text) {
        fulltip.add(text);
    }

    //Adds a line of text to a specific line.
    public void addToTooltipAt(int location, MutableText text) {
        fulltip.add(location, text);
    }

    //Removes first instance of the specified text.
    public boolean removeFromTooltip(MutableText text) {
        boolean flag = false;
        for(int i = 0; i < fulltip.size(); i++){
            if (text == fulltip.get(i)){
                fulltip.remove(i);
                flag = true;
                break;
            }
        }
        return flag;
    }

    //Removes all instances of the specified text.
    public int removeAllFromTooltip(MutableText text) {
        int count = 0;
        for(int i = 0; i < fulltip.size(); i++){
            if (text == fulltip.get(i)){
                fulltip.remove(i);
                count += 1;
            }
        }
        return count;
    }

    //Returns the tooltip entries as a list.
    public List<MutableText> getEntries() {
        return fulltip;
    }

}
