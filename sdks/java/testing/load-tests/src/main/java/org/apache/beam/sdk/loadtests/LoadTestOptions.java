/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.beam.sdk.loadtests;

import org.apache.beam.sdk.options.ApplicationNameOptions;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.options.StreamingOptions;
import org.apache.beam.sdk.options.Validation;

/** Common interface for all load test options. */
public interface LoadTestOptions extends PipelineOptions, ApplicationNameOptions, StreamingOptions {

  @Description("Options for synthetic source")
  @Validation.Required
  String getSourceOptions();

  void setSourceOptions(String sourceOptions);

  @Description("Options for synthetic step")
  String getStepOptions();

  void setStepOptions(String stepOptions);

  @Description("Whether the results should be published to BigQuery database")
  @Default.Boolean(false)
  Boolean getPublishToBigQuery();

  void setPublishToBigQuery(Boolean publishToBigQuery);

  @Description("BigQuery dataset name")
  String getBigQueryDataset();

  void setBigQueryDataset(String dataset);

  @Description("BigQuery table name")
  String getBigQueryTable();

  void setBigQueryTable(String tableName);

  static <T extends LoadTestOptions> T readFromArgs(String[] args, Class<T> optionsClass) {
    return PipelineOptionsFactory.fromArgs(args).withValidation().as(optionsClass);
  }
}
