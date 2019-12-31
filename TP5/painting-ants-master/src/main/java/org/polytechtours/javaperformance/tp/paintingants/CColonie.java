package org.polytechtours.javaperformance.tp.paintingants;

import java.util.List;
/*
 * CColonie.java
 *
 * Created on 11 avril 2007, 16:35
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
import java.util.Vector;

public class CColonie {

	private List<CFourmi> mColonie;
	private List<Thread> mColonieThreads;
	private PaintingAnts mApplis;

	/** Creates a new instance of CColonie */
	public CColonie(List<CFourmi> pColonie, PaintingAnts pApplis) {
		mColonie = pColonie;
		mApplis = pApplis;
		mColonieThreads = new Vector<Thread>();
	}

	/** Démarrer le thread principal */
	public void start() {
		for (int i = 0; i < mColonie.size(); i++) {
			Thread newThread = new Thread(mColonie.get(i));
			newThread.start();
			mColonieThreads.add(newThread);
		}
	}

	/** Attendez que tous les threads se terminent */
	public void pleaseStop() {
		for (int i = 0; i < mColonieThreads.size(); i++) {
			mColonie.get(i).pleaseStop();
			try {
				mColonieThreads.get(i).join();
			} catch (Exception e) {

			}
		}
	}
}
