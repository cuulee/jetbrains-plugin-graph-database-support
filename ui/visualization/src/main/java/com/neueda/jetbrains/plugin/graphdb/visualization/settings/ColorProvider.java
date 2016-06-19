package com.neueda.jetbrains.plugin.graphdb.visualization.settings;

import com.neueda.jetbrains.plugin.graphdb.visualization.services.LookAndFeelService;
import org.jetbrains.annotations.NotNull;
import prefuse.action.ActionList;
import prefuse.action.assignment.ColorAction;
import prefuse.action.assignment.DataColorAction;
import prefuse.action.assignment.StrokeAction;
import prefuse.util.ColorLib;

import java.awt.*;

import static com.neueda.jetbrains.plugin.graphdb.visualization.constants.GraphColumns.TYPE;
import static com.neueda.jetbrains.plugin.graphdb.visualization.constants.GraphGroups.EDGES;
import static com.neueda.jetbrains.plugin.graphdb.visualization.constants.GraphGroups.NODES;
import static prefuse.Constants.NOMINAL;
import static prefuse.visual.VisualItem.*;

public class ColorProvider {

    /**
     * Pastel color palette for node coloring
     */
    private static final int ROT_1 = ColorLib.rgb(219, 94, 86);
    private static final int ROT_2 = ColorLib.rgb(219, 194, 86);
    private static final int ROT_3 = ColorLib.rgb(145, 219, 86);
    private static final int ROT_4 = ColorLib.rgb(86, 219, 127);
    private static final int ROT_5 = ColorLib.rgb(86, 211, 219);
    private static final int ROT_6 = ColorLib.rgb(86, 111, 219);
    private static final int ROT_7 = ColorLib.rgb(160, 86, 219);
    private static final int ROT_8 = ColorLib.rgb(219, 86, 178);

    private static final int ORANGE = ColorLib.rgb(229, 60, 20);
    private static final int ORANGE_DARK = ColorLib.rgb(180, 40, 8);
    private static final int GREEN = ColorLib.rgb(132, 173, 74);
    private static final int GRAY = ColorLib.rgb(89, 89, 89);

    private static final int EDGE = GREEN;
    private static final int EDGE_HOVER = ORANGE_DARK;
    private static final int EDGE_HIGHLIGHT = ORANGE_DARK;

    private static final int NODE_STROKE = GRAY;
    private static final int NODE_STROKE_HOVER = ORANGE_DARK;
    private static final int NODE_STROKE_HIGHLIGHT = ORANGE_DARK;

    private static final int[] palette = { ROT_1, ROT_2, ROT_3, ROT_4, ROT_5, ROT_6, ROT_7, ROT_8 };

    public static ActionList colors(LookAndFeelService lookAndFeelService) {
        ActionList colors = new ActionList();

        colors.add(getNodeStroke(lookAndFeelService));
        colors.add(getEdgeStroke(lookAndFeelService));
        colors.add(getEdgeFill(lookAndFeelService));
        colors.add(getNodeFill(lookAndFeelService));
        colors.add(getStrokeThickness());

        return colors;
    }

    private static StrokeAction getStrokeThickness() {
        StrokeAction stroke = new StrokeAction(NODES, new BasicStroke(5));
        stroke.add(HIGHLIGHT, new BasicStroke(5));
        stroke.add(HOVER, new BasicStroke(5));

        return stroke;
    }

    @NotNull
    private static DataColorAction getNodeFill(LookAndFeelService lookAndFeelService) {
        DataColorAction fill = new DataColorAction(NODES, TYPE, NOMINAL, FILLCOLOR, palette);

        return fill;
    }

    @NotNull
    private static ColorAction getEdgeFill(LookAndFeelService lookAndFeelService) {
        ColorAction arrow = new ColorAction(EDGES, FILLCOLOR, EDGE);
        arrow.add(HIGHLIGHT, EDGE_HIGHLIGHT);
        arrow.add(HOVER, EDGE_HOVER);

        return arrow;
    }

    @NotNull
    private static ColorAction getEdgeStroke(LookAndFeelService lookAndFeelService) {
        ColorAction nEdges = new ColorAction(EDGES, STROKECOLOR, EDGE);
        nEdges.add(HIGHLIGHT, EDGE_HIGHLIGHT);
        nEdges.add(HOVER, EDGE_HOVER);

        return nEdges;
    }

    @NotNull
    private static ColorAction getNodeStroke(LookAndFeelService lookAndFeelService) {
        ColorAction nStroke = new DataColorAction(NODES, TYPE, NOMINAL, STROKECOLOR, palette);
        nStroke.add(HIGHLIGHT, NODE_STROKE_HIGHLIGHT);
        nStroke.add(HOVER, NODE_STROKE_HOVER);
        return nStroke;
    }
}