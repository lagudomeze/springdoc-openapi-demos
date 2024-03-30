/*
 *
 *  * Copyright 2019-2020 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      https://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.8).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.springdoc.demo.app1.sample2;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-07-08T09:37:36.546Z[GMT]")
@Tag(name = "inventory")
public interface InventoryApi {


	@Operation(description = "adds an inventory item", operationId = "addInventory", summary = "Adds an item to the system", tags = {
			"admins", })
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "item created"),
			@ApiResponse(responseCode = "400", description = "invalid input, object invalid"),
			@ApiResponse(responseCode = "409", description = "an existing item already exists") })
	@PostMapping(value = "/inventory", consumes = { "application/json" })
	ResponseEntity<Void> addInventory(
			@Parameter(description = "Inventory item to do") @Valid @RequestBody InventoryItem body);

	@Operation(description = "searches inventory", operationId = "searchInventory", summary = "By passing in the appropriate options, you can search for available inventory in the system ", tags = {
			"developers", })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "search results matching criteria"),
			@ApiResponse(responseCode = "400", description = "bad input parameter") })
	@GetMapping(value = "/inventory", produces = { "application/json" })
	ResponseEntity<List<InventoryItem>> searchInventory(
			@Valid @RequestParam(value = "searchString", required = false) String searchString,
			@Min(0) @Parameter(description = "number of records to skip for pagination") @Valid @RequestParam(value = "skip", required = true) Integer skip,
			@Min(0) @Max(50) @Parameter(description = "maximum number of records to return") @Valid @RequestParam(value = "limit", required = true) Integer limit);

}
