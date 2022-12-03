package net.thatcasual.essencefoundry.util;

import net.minecraft.text.MutableText;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DynamicTooltip {

    private ArrayList<MutableText> dynamic_tooltip = new ArrayList<MutableText>();

    public DynamicTooltip(){}

    //Constructor for a single line of text on item registration.
    public DynamicTooltip(MutableText text) {
            dynamic_tooltip.add(text);
    }

    //Constructor for multiple lines of text on item registration.
    public DynamicTooltip(List<MutableText> textlist) {
        if(textlist != null) {
            for (int i = 0; i < textlist.size(); i++) {
                if (textlist.get(i) != null) {
                    dynamic_tooltip.add(textlist.get(i));
                }
            }
        }
    }

    //Adds text to the end of the tooltip.
    public void addToTooltip(MutableText text) {
        dynamic_tooltip.add(text);
    }

    //Adds a line of text to a specific line.
    public void addToTooltipAt(int location, MutableText text) {
        dynamic_tooltip.add(location, text);
    }

    //Removes first instance of the specified text.
    public boolean removeFromTooltip(MutableText text) {
        boolean flag = false;
        for(int i = 0; i < dynamic_tooltip.size(); i++){
            if (text == dynamic_tooltip.get(i)){
                dynamic_tooltip.remove(i);
                flag = true;
                break;
            }
        }
        return flag;
    }

    //Removes all instances of the specified text.
    public int removeAllFromTooltip(MutableText text) {
        int count = 0;
        for(int i = 0; i < dynamic_tooltip.size(); i++){
            if (text == dynamic_tooltip.get(i)){
                dynamic_tooltip.remove(i);
                count += 1;
                i--;
            }
        }
        return count;
    }

    //Returns the tooltip entries as a list.
    public List<MutableText> getEntries() {
        return dynamic_tooltip;
    }

}
