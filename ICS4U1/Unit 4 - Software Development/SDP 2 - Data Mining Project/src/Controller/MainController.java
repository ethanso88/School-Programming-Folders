package Controller;

import View.*;
import View.FarmProductionPackage.FarmProductionPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MainController implements ActionListener {

	MainFrame mainFrame;
	MenuPanel menuPanel;
	ImportExportPanel importExportPanel = new ImportExportPanel();
	ConsumerCostsPanel consumerCostsPanel = new ConsumerCostsPanel();
	FarmProductionPanel farmProductionPanel = new FarmProductionPanel();
	FarmSustainabilityPanel farmSustainabilityPanel = new FarmSustainabilityPanel();

	public MainController() {
		mainFrame = new MainFrame();
		menuPanel = new MenuPanel();

		// Set controller for farmProductionPanel so it can call back
		farmProductionPanel.setController(this);

		for (int i = 0; i < 4; i++) {
			mainFrame.getMenuItems()[i].addActionListener(this);
			menuPanel.getMenuButtons()[i].addActionListener(this);
		}
		mainFrame.getMenuItems()[4].addActionListener(this);

		mainFrame.setCurrentPanel(menuPanel);
		mainFrame.add(menuPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuPanel.getMenuButtons()[0]) {
			mainFrame.addMenuBar();
			switchToConsumerCostsPanel();
		} else if (e.getSource() == menuPanel.getMenuButtons()[1]) {
			mainFrame.addMenuBar();
			switchToImportExportPanel();
		} else if (e.getSource() == menuPanel.getMenuButtons()[2]) {
			mainFrame.addMenuBar();
			switchToFarmProductionPanel();
		} else if (e.getSource() == menuPanel.getMenuButtons()[3]) {
			mainFrame.addMenuBar();
			System.out.println("dsf");
			switchToFarmSustainabilityPanel();
		} else if (e.getSource() == mainFrame.getMenuItems()[0]) {
			switchToImportExportPanel();
		} else if (e.getSource() == mainFrame.getMenuItems()[1]) {
			switchToConsumerCostsPanel();
		} else if (e.getSource() == mainFrame.getMenuItems()[2]) {
			switchToFarmProductionPanel();
		} else if (e.getSource() == mainFrame.getMenuItems()[3]) {
			switchToFarmSustainabilityPanel();
		} else if (e.getSource() == mainFrame.getMenuItems()[4]) {
			int choice = JOptionPane.showConfirmDialog(
					null,
					"Are you sure you want to quit?",
					"Confirm Quit",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE
			);
			if (choice == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

	public void switchToMenuPanel() {
		removeCurrentPanel();
		mainFrame.setCurrentPanel(menuPanel);
		mainFrame.add(menuPanel, BorderLayout.CENTER);
		refresh();
	}

	private void switchToFarmSustainabilityPanel() {
		removeCurrentPanel();
		mainFrame.setCurrentPanel(farmSustainabilityPanel);
		mainFrame.add(farmSustainabilityPanel, BorderLayout.CENTER);
		refresh();
	}

	private void switchToFarmProductionPanel() {
		removeCurrentPanel();
		mainFrame.setCurrentPanel(farmProductionPanel);
		mainFrame.add(farmProductionPanel, BorderLayout.CENTER);
		refresh();
	}

	private void switchToImportExportPanel() {
		removeCurrentPanel();
		mainFrame.setCurrentPanel(importExportPanel);
		mainFrame.add(importExportPanel, BorderLayout.CENTER);
		refresh();
	}

	private void switchToConsumerCostsPanel() {
		removeCurrentPanel();
		mainFrame.setCurrentPanel(consumerCostsPanel);
		mainFrame.add(consumerCostsPanel, BorderLayout.CENTER);
		refresh();
	}

	public void removeCurrentPanel() {
		mainFrame.remove(mainFrame.getCurrentPanel());
	}

	public void refresh() {
		mainFrame.revalidate();
		mainFrame.repaint();
	}
}
