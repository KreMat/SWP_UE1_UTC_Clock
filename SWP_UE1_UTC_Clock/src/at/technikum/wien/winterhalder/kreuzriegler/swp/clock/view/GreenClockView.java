/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model.Clock;

/**
 * @author richie
 * 
 */
public class GreenClockView extends AbstractClockView {

	private JFrame frame;
	private JLabel hourField;
	private JLabel minuteField;
	private JLabel secondField;

	public GreenClockView(Clock clock, int timezone) {
		super(clock, timezone);
		
		frame = new JFrame();
		JPanel panel = new JPanel();

		panel.add(new JLabel("Hours:"));
		hourField = new JLabel(clock.getHour() + "");
		panel.add(hourField);

		panel.add(new JLabel("Minutes:"));
		minuteField = new JLabel(clock.getMinute() + "");
		panel.add(minuteField);

		panel.add(new JLabel("Seconds:"));
		secondField = new JLabel(clock.getSecond() + "");
		panel.add(secondField);
		
		frame.setBackground(Color.green);

		frame.add(panel, BorderLayout.CENTER);

		// add the clock
		frame.pack();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.clock.view.AbstractClockView
	 * #show(int, int)
	 */
	@Override
	public void show(int x, int y) {
		update();
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocation(x, y);
		frame.pack();
	}

	@Override
	public void update() {
		//TODO implement timezone

		hourField.setText(clock.getHour() + "");
		minuteField.setText(clock.getMinute() + "");
		secondField.setText(clock.getSecond() + "");
		frame.pack();
		frame.repaint();
	}

	@Override
	public void close() {
		frame.setVisible(false);
		
	}

}
