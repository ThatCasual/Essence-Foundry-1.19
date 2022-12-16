package net.thatcasual.essencefoundry.util;

import net.minecraft.item.Item;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.HashMap;

public class ModBlockEntitySideManager {

    public static final String TOP = "top";
    public static final String BOTTOM = "bottom";
    public static final String FRONT = "front";
    public static final String BACK = "back";
    public static final String LEFT = "left";
    public static final String RIGHT = "right";

    public HashMap<Direction, String> blockSideWorldDirections = new HashMap<>();

    private HashMap<String, HashMap<Integer, ArrayList<Item>>> insertAllowances;
    private HashMap<String, HashMap<Integer, ArrayList<Item>>> extractAllowances;

    public ModBlockEntitySideManager(int size){
        buildAllowanceMaps(size);
    }

    private void buildAllowanceMaps(int size) {
        ArrayList<String> sides = new ArrayList<>(){{add(TOP);add(BOTTOM);add(FRONT);add(BACK);add(LEFT);add(RIGHT);}};
        HashMap<String, HashMap<Integer, ArrayList<Item>>> tempMap = new HashMap<>(){{
            for (String side : sides){
                put(side, new HashMap<Integer, ArrayList<Item>>(){{
                    for (int i = 0; i < size; i++){
                        put(i, new ArrayList<Item>());
                    }
                }});
            }
        }};

        this.insertAllowances = tempMap;
        this.extractAllowances = tempMap;
    }

    private void buildSideMap(Direction facing){
        this.blockSideWorldDirections.put(Direction.UP, TOP);
        this.blockSideWorldDirections.put(Direction.DOWN, BOTTOM);

        if (facing == Direction.NORTH) {
            this.blockSideWorldDirections.put(Direction.NORTH, FRONT);
            this.blockSideWorldDirections.put(Direction.SOUTH, BACK);
            this.blockSideWorldDirections.put(Direction.EAST, LEFT);
            this.blockSideWorldDirections.put(Direction.WEST, RIGHT);
        }

        if (facing == Direction.SOUTH) {
            this.blockSideWorldDirections.put(Direction.SOUTH, FRONT);
            this.blockSideWorldDirections.put(Direction.NORTH, BACK);
            this.blockSideWorldDirections.put(Direction.WEST, LEFT);
            this.blockSideWorldDirections.put(Direction.EAST, RIGHT);
        }

        if (facing == Direction.EAST){
            this.blockSideWorldDirections.put(Direction.EAST, FRONT);
            this.blockSideWorldDirections.put(Direction.WEST, BACK);
            this.blockSideWorldDirections.put(Direction.SOUTH, LEFT);
            this.blockSideWorldDirections.put(Direction.NORTH, RIGHT);
        }

        if (facing == Direction.WEST){
            this.blockSideWorldDirections.put(Direction.WEST, FRONT);
            this.blockSideWorldDirections.put(Direction.EAST, BACK);
            this.blockSideWorldDirections.put(Direction.NORTH, LEFT);
            this.blockSideWorldDirections.put(Direction.SOUTH, RIGHT);
        }

    }

    public void registerInsert(String side, int slot, Item item){
        this.insertAllowances.get(side).get(slot).add(item);
    }

    public void registerExtract(String side, int slot, Item item){
        this.extractAllowances.get(side).get(slot).add(item);
    }

    public boolean checkIsAllowedInsert(Direction facing, Direction side, int slot, Item item){
        buildSideMap(facing);
        String blockSide = blockSideWorldDirections.get(side);
        return this.insertAllowances.get(blockSide).get(slot).contains(item);
    }

    public boolean checkIsAllowedExtract(Direction facing, Direction side, int slot, Item item){
        buildSideMap(facing);
        String blockSide = blockSideWorldDirections.get(side);
        return this.extractAllowances.get(blockSide).get(slot).contains(item);
    }

    public HashMap<Direction, String> getSides(Direction localDirection){
        return this.blockSideWorldDirections;
    }

}
