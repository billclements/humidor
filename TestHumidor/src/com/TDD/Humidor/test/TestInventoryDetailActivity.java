package com.TDD.Humidor.test;

/**
 * Author: Megan Clark
 */
import android.test.ActivityInstrumentationTestCase2;

import com.TDD.Humidor.InventoryDetailActivity;

public class TestInventoryDetailActivity extends
		ActivityInstrumentationTestCase2<InventoryDetailActivity> {

	public TestInventoryDetailActivity() {
		this("TestInventoryDetailActivity");
	}

	public TestInventoryDetailActivity(String name) {
		super(InventoryDetailActivity.class);
		setName(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		// TODO setup fixture
	}

	public final void testPreconditions() {
		// TODO setup preconditions
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
