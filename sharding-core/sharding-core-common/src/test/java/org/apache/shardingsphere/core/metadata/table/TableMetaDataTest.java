/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.core.metadata.table;

import org.apache.shardingsphere.core.metadata.column.ColumnMetaData;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertTrue;

public final class TableMetaDataTest {
    
    @Test
    public void assertContainsIndex() {
        TableMetaData tableMetaData = new TableMetaData(Collections.singletonList(new ColumnMetaData("name", "dataType", true, true, true)), Collections.singleton("indexName"));
        assertTrue(tableMetaData.containsIndex("indexName"));
    }
    
    @Test
    public void assertColumnPrimaryKey() {
        TableMetaData tableMetaData = new TableMetaData(Collections.singletonList(new ColumnMetaData("id", "dataType", true, false, false)), Collections.<String>emptyList());
        assertTrue(tableMetaData.getColumns().get("id").isPrimaryKey());
    }
    
    @Test
    public void assertColumnNotNull() {
        TableMetaData tableMetaData = new TableMetaData(Collections.singletonList(new ColumnMetaData("id", "dataType", false, true, false)), Collections.<String>emptyList());
        assertTrue(tableMetaData.getColumns().get("id").isNotNull());
    }
    
    @Test
    public void assertColumnAutoIncrement() {
        TableMetaData tableMetaData = new TableMetaData(Collections.singletonList(new ColumnMetaData("id", "dataType", false, false, true)), Collections.<String>emptyList());
        assertTrue(tableMetaData.getColumns().get("id").isAutoIncrement());
    }
}
