/**
 * View Pager Test is a small application to demonstrate how to use
 * this excellent class provided by the android compatibility package
 * to swap between running parts of an application with your finger.
 * Copyright (C) 2013	Alexandro Blanco <ti3r.bubblenet@gmail.com>
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

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/**
 * View Pager Adapter that will handle the different added fragments
 * on a simple array list.
 * @author Alexandro Blanco <ti3r.bubblenet@gmail.com>
 *
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter{

	List<Fragment> fragments = null;
	public MyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		fragments = new ArrayList<Fragment>();
	}
	public void addFragment(Fragment fragment){
		fragments.add(fragment);
	}
	@Override
	public Fragment getItem(int arg0) {
		return fragments.get(arg0);
	}
	@Override
	public int getCount() {
		return fragments.size();
	}
}
