package com.gsitm.ustra.java.sample.api.example;

import java.util.List;

import com.gsitm.ustra.java.data.domains.PaginationList;
import com.gsitm.ustra.java.data.domains.PaginationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("U.STRA Examples for API")
@RestController
@RequestMapping("/api/example")
public class ExampleController {

    @Autowired
    private ExampleService exampleService;


    /*
     * feauture branch commit 수정됨
     *
     *
     */

    @GetMapping("/common/code")
    @ApiOperation(value = "�쟾泥� 肄붾뱶 紐⑸줉 議고쉶", notes = "<strong>肄붾뱶 �쟾泥� 紐⑸줉</string>�쓣 諛섑솚")
    public List<ExampleModel> getAll(@ApiParam("�궗�슜 �뿬遺�") String useYn) {

        ExampleModel.Criteria criteria = new ExampleModel.Criteria();
        criteria.setUseYn(useYn);

        return this.exampleService.getAll(criteria);
    }

    @PostMapping("/common/code/page")
    @ApiOperation(value = "�럹�씠吏�蹂� 肄붾뱶 紐⑸줉 議고쉶", notes = "�럹�씠吏�蹂� 肄붾뱶 紐⑸줉�쓣 諛섑솚")
    public PaginationList<ExampleModel> getCodesByPage(@RequestBody PaginationRequest request) {
        return this.exampleService.getCodes(request);
    }
    /* example for testing getCodesByPage() method using REST Client in VSCode:
POST http://localhost:8981/api/example/common/code/page HTTP/1.1
Content-Type: application/json

{
	"currentPage": 5,
	"pageSize": 5,
	"orders": [
		{ "name": "CD_NM", "direction": "ASC" }
	]
}
     */
}
