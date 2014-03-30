/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.clock.view;

import java.awt.BorderLayout;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import at.technikum.wien.winterhalder.kreuzriegler.swp.clock.model.Clock;

/**
 * @author Matthias
 * 
 */
public class AbstractColoredClockView extends AbstractClockView {

	protected JFrame frame;
	protected JLabel hourField;
	protected JLabel minuteField;
	protected JLabel secondField;
	protected JPanel panel;

	public AbstractColoredClockView(Clock clock, int timezone) {
		super(clock, timezone);

		frame = new JFrame();
		panel = new JPanel();

		hourField = new JLabel();
		panel.add(hourField);

		panel.add(new JLabel(":"));
		minuteField = new JLabel();
		panel.add(minuteField);

		panel.add(new JLabel(":"));
		secondField = new JLabel();
		panel.add(secondField);

		frame.add(panel, BorderLayout.CENTER);

		update();

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
		Calendar cal = Calendar.getInstance();
		cal.setLenient(true);

		cal.set(Calendar.HOUR_OF_DAY, clock.getHour());
		cal.set(Calendar.MINUTE, clock.getMinute() + timezone);
		cal.set(Calendar.SECOND, clock.getSecond());

		hourField.setText(cal.get(Calendar.HOUR_OF_DAY) + "");
		minuteField.setText(cal.get(Calendar.MINUTE) + "");
		secondField.setText(cal.get(Calendar.SECOND) + "");
		frame.pack();
		frame.repaint();
	}

	@Override
	public void close() {
		frame.setVisible(false);

	}

}
