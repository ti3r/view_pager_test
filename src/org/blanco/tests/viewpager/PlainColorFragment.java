/**
 * View Pager Test is a small application to demonstrate how to use
 * this excellent class provided by the android compatibility package
 * to swap between running parts of an application with your finger.
 * Copyright (C) 2011 Alexandro Blanco <ti3r.bubblenet@gmail.com>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.blanco.tests.viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AnalogClock;

public class PlainColorFragment extends Fragment {

  private static final String PLAIN_COLOR_FRAG_ARG_COLOR = "color";
  private static final String PLAIN_COLOR_FRAG_ARG_ALPHA = "alpha";
  
  int color = Color.GREEN;
  View view = null;
  AnalogClock clock = null;
  Bundle viewRecreateState = new Bundle();
  
  public static PlainColorFragment newInstance(int color) {
    PlainColorFragment frag = new PlainColorFragment();
    Bundle frag1Args = new Bundle();
    frag1Args.putInt(PLAIN_COLOR_FRAG_ARG_COLOR, color);
    frag.setArguments(frag1Args);
    frag.setRetainInstance(true);
    return frag;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.color = (getArguments() != null) ? getArguments().getInt(PLAIN_COLOR_FRAG_ARG_COLOR) : Color.GRAY;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.color_layout, container, false);
    clock = (AnalogClock) view.findViewById(R.id.analogClock1);
    clock.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        vanishClock();
      }
    });
    //If bundle comes from system to recreate saved state put in property
    //to be available to restoreClockState
    if (savedInstanceState != null)
      viewRecreateState.putAll(savedInstanceState);
    
    restoreClockState();
    view.setBackgroundColor(color);
    return view;
  }
  
  @Override
  public void onDestroyView() {
    viewRecreateState.putFloat(PLAIN_COLOR_FRAG_ARG_ALPHA, clock.getAlpha());
    super.onDestroyView();
  }
  
  private void restoreClockState() {
    float alpha = 1.0f;
    if (viewRecreateState != null && 
        viewRecreateState.containsKey(PLAIN_COLOR_FRAG_ARG_ALPHA))
      alpha = viewRecreateState.getFloat(PLAIN_COLOR_FRAG_ARG_ALPHA);
    clock.setAlpha(alpha);
  }

  public void startAnimationOnClock() {
    Animation anim = AnimationUtils.loadAnimation(getActivity(), 
        android.R.anim.fade_out);
    clock.startAnimation(anim);
  }

  public void vanishClock() {
    if (clock.getAlpha() < 0.4f)
      clock.setAlpha(1.0f);
    else
      clock.setAlpha(clock.getAlpha() - .2f);
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    outState.putFloat(PLAIN_COLOR_FRAG_ARG_ALPHA, clock.getAlpha());
    super.onSaveInstanceState(outState);
  }

  
  
}
