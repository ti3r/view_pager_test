/**
 * View Pager Test is a small application to demonstrate how to use
 * this excellent class provided by the android compatibility package
 * to swap between running parts of an application with your finger.
 * Copyright (C) 2011	Alexandro Blanco <ti3r.bubblenet@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.blanco.tests.viewpager;

import android.support.v4.view.ViewPager.OnPageChangeListener;
/**
 * Class to detect changes on the page index of the ViewPager 
 * and save the current index.
 * @author Alexandro Blanco <ti3r.bubblenet@gmail.com>
 *
 */
public class PageChangeListener implements OnPageChangeListener {

	int currentIndex = 0;
	
	@Override
	public void onPageScrollStateChanged(int arg0) {
		//Do Nothing
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		//No Nothing
	}

	@Override
	public void onPageSelected(int arg0) {
		currentIndex = arg0;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}
}
