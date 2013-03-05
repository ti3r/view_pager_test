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

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
/**
 * Main activity of the application
 * @author Alexandro Blanco <ti3r.bubblenet@gmail.com>
 *
 */
public class MainActivity extends FragmentActivity {
    
	ViewPager pager = null;
	PageChangeListener pageChangeListener = null;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        pager = (ViewPager) findViewById(R.id.pager);
        
        MyFragmentPagerAdapter adapter = 
        		new MyFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PlainColorFragment(Color.RED));
        adapter.addFragment(new PlainColorFragment(Color.GREEN));
        adapter.addFragment(new PlainColorFragment(Color.BLUE));
        pageChangeListener = new PageChangeListener();
        pager.setOnPageChangeListener(pageChangeListener);
        pager.setAdapter(adapter);
    }

    private void startAnimationOnCurrentPage(){
    	MyFragmentPagerAdapter adapter =  
    			(MyFragmentPagerAdapter) pager.getAdapter();
    	PlainColorFragment fragment = 
    			(PlainColorFragment) adapter.getItem(pageChangeListener.getCurrentIndex());
    	fragment.startAnimationOnClock();
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.main_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.main_menu_start_anim_current_item:
				startAnimationOnCurrentPage();
			default:
				return super.onOptionsItemSelected(item);
		}
	}
    
    
    
}