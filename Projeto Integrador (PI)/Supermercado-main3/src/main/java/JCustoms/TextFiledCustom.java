package JCustoms;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TextFiledCustom extends JTextField {

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        border.setRound(round);
        repaint();
    }

    private Border border;
    private int round = 15;

    public TextFiledCustom() {
        border = new Border(10);
        border.setRound(round);
        setBorder(border);
        setOpaque(false);
        setSelectedTextColor(Color.WHITE);
        setSelectionColor(new Color(54, 189, 248));
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                border.setColor(new Color(128, 189, 255));
                repaint();
            }

            @Override
            public void focusLost(FocusEvent fe) {
                border.setColor(new Color(206, 212, 218));
                repaint();
            }
        });
    }

    private class Border extends EmptyBorder {

        public int getRound() {
            return round;
        }

        public void setRound(int round) {
            this.round = round;
        }

        public Color getFocusColor() {
            return focusColor;
        }

        public void setFocusColor(Color focusColor) {
            this.focusColor = focusColor;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        private Color focusColor = new Color(128, 189, 255);
        private Color color = new Color(206, 212, 218);
        private int round;

        public Border(int border) {
            super(border, border, border, border);
        }

        public Border() {
            this(5);
        }

        @Override
        public void paintBorder(Component cmpnt, Graphics grphcs, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (cmpnt.isFocusOwner()) {
                g2.setColor(focusColor);
            } else {
                g2.setColor(color);
            }
            g2.drawRoundRect(x, y, width - 1, height - 1, round, round);
            g2.dispose();
        }
        
        
    }
}
