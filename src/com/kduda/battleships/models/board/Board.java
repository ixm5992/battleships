package com.kduda.battleships.models.board;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Board extends Parent {
    public int units = 19;
    private VBox column = new VBox();
    private boolean isEnemyBoard = false;


    public Board(boolean isEnemyBoard, EventHandler<? super MouseEvent> mouseClickHandler, EventHandler<? super MouseEvent> mouseMovedHandler) {
        this.isEnemyBoard = isEnemyBoard;
        for (int y = 0; y < 22; y++) {
            HBox row = new HBox();
            for (int x = 0; x < 14; x++) {
                Cell cell = new Cell(x, y, this);
                cell.setOnMouseClicked(mouseClickHandler);
                cell.setOnMouseMoved(mouseMovedHandler);
                row.getChildren().add(cell);
            }
            column.getChildren().add(row);
        }
        getChildren().add(column);
    }

//    public boolean placeShip(Ship ship, int x, int y) {
//        if (canPlaceShip(ship, x, y)) {
//            int length = ship.type;
//
//            if (ship.vertical) {
//                for (int i = y; i < y + length; i++) {
//                    Cell cell = getCell(x, i);
//                    cell.ship = ship;
//                    if (!isEnemyBoard) {
//                        cell.setFill(Color.WHITE);
//                        cell.setStroke(Color.GREEN);
//                    }
//                }
//            } else {
//                for (int i = x; i < x + length; i++) {
//                    Cell cell = getCell(i, y);
//                    cell.ship = ship;
//                    if (!isEnemyBoard) {
//                        cell.setFill(Color.WHITE);
//                        cell.setStroke(Color.GREEN);
//                    }
//                }
//            }
//
//            return true;
//        }
//
//        return false;
//    }
//
//    public Cell getCell(int x, int y) {
//        return (Cell) ((HBox) column.getChildren().get(y)).getChildren().get(x);
//    }
//
//    private Cell[] getNeighbors(int x, int y) {
//        Point2D[] points = new Point2D[]{
//                new Point2D(x - 1, y),
//                new Point2D(x + 1, y),
//                new Point2D(x, y - 1),
//                new Point2D(x, y + 1)
//        };
//
//        List<Cell> neighbors = new ArrayList<Cell>();
//
//        for (Point2D p : points) {
//            if (isValidPoint(p)) {
//                neighbors.add(getCell((int) p.getX(), (int) p.getY()));
//            }
//        }
//
//        return neighbors.toArray(new Cell[0]);
//    }
//
//    private boolean canPlaceShip(Ship ship, int x, int y) {
//        int length = ship.type;
//
//        if (ship.vertical) {
//            for (int i = y; i < y + length; i++) {
//                if (!isValidPoint(x, i))
//                    return false;
//
//                Cell cell = getCell(x, i);
//                if (cell.ship != null)
//                    return false;
//
//                for (Cell neighbor : getNeighbors(x, i)) {
//                    if (!isValidPoint(x, i))
//                        return false;
//
//                    if (neighbor.ship != null)
//                        return false;
//                }
//            }
//        } else {
//            for (int i = x; i < x + length; i++) {
//                if (!isValidPoint(i, y))
//                    return false;
//
//                Cell cell = getCell(i, y);
//                if (cell.ship != null)
//                    return false;
//
//                for (Cell neighbor : getNeighbors(i, y)) {
//                    if (!isValidPoint(i, y))
//                        return false;
//
//                    if (neighbor.ship != null)
//                        return false;
//                }
//            }
//        }
//
//        return true;
//    }
//
//    private boolean isValidPoint(Point2D point) {
//        return isValidPoint(point.getX(), point.getY());
//    }
//
//    private boolean isValidPoint(double x, double y) {
//        return x >= 0 && x < 10 && y >= 0 && y < 10;
//    }
}