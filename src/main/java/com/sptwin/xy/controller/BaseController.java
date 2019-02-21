package com.sptwin.xy.controller;

import com.sptwin.xy.entity.SelfTrade;
import com.sptwin.xy.enums.*;
import com.sptwin.xy.service.*;
import com.sptwin.xy.utils.BaseApiService;
import com.sptwin.xy.utils.ExcelParser;
import com.sptwin.xy.utils.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Api(description = "下拉选择相关的接口API")
@RestController
public class BaseController extends BaseApiService {

    @Autowired
    private ExchangeService exchangeService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private ClientAgentService clientAgentService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private TradeService tradeService;
    @Autowired
    private ExcelService excelService;
    @Autowired
    private ExcelParser excelParser;
    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation("后台登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping("/backend/login")
    public ResponseBase login(String userName, String password, HttpServletRequest request){
        ResponseBase responseBase = sysUserService.loginCheck(userName, password, request);
        return responseBase;
    }
    @ApiOperation("退出")
    @GetMapping("/logout")
    public ResponseBase logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return setResultSuccess();
    }
    @ApiOperation("查询所有角色")
    @GetMapping("/base/role/all")
    public ResponseBase queryRole(){
        ResponseBase responseBase = sysRoleService.queryRole();
        return responseBase;
    }
    @ApiOperation("查询所有客户代理")
    @GetMapping("/base/clientAgent/all")
    public ResponseBase queryClientAgent(){
        ResponseBase responseBase = clientAgentService.queryClientAgent();
        return responseBase;
    }
    @ApiOperation("查询所有市场编号")
    @GetMapping("/base/exchange/no")
    public ResponseBase queryExchangeNo(){
        ResponseBase responseBase = exchangeService.queryExchangeNo();
        return responseBase;
    }
    @ApiOperation("查询所有货币编号")
    @GetMapping("/base/currency/no")
    public ResponseBase queryCurrencyNo(){
        ResponseBase responseBase = currencyService.queryCurrencyNo();
        return responseBase;
    }

    @ApiOperation("查询合约状态枚举")
    @GetMapping("/base/contract/status")
    public ResponseBase queryContractStatus(){
        List list = new ArrayList();
        for(ContractStatus contractStatus : ContractStatus.values()){
            list.add(contractStatus);
        }
        return setResultSuccess(list);
    }
    @ApiOperation("查询品种状态枚举")
    @GetMapping("/base/commodity/status")
    public ResponseBase queryCommodityStatus(){
        List list = new ArrayList();
        for(CommodityStatus commodityStatus : CommodityStatus.values()){
            list.add(commodityStatus);
        }
        return setResultSuccess(list);
    }

    @ApiOperation("查询货币状态枚举")
    @GetMapping("/base/currency/status")
    public ResponseBase queryCurrencyStatus(){
        List list = new ArrayList();
        for(CurrencyStatus currencyStatus : CurrencyStatus.values()){
            list.add(currencyStatus);
        }
        return setResultSuccess(list);
    }
    @ApiOperation("查询市场状态枚举")
    @GetMapping("/base/exchange/status")
    public ResponseBase queryExchangeStatus(){
        List list = new ArrayList();
        for(ExchangeStatus exchangeStatus : ExchangeStatus.values()){
            list.add(exchangeStatus);
        }
        return setResultSuccess(list);
    }
    @ApiOperation("查询客户状态枚举")
    @GetMapping("/base/client/status")
    public ResponseBase queryClientStatus(){
        List list = new ArrayList();
        for(ClientStatus clientStatus : ClientStatus.values()){
            list.add(clientStatus);
        }
        return setResultSuccess(list);
    }
    @ApiOperation("鉴权返回状态")
    @GetMapping("/base/unauthentication")
    public ResponseBase unauthentication(){
        return setResultError(401,"no power");
    }

    @RequestMapping(value = "/base/tradePage")
    public ModelAndView tradePage() {
        return new ModelAndView("TradeList");
    }
    @RequestMapping(value = "/base/importPage")
    public ModelAndView importPage() {
        return new ModelAndView("import");
    }
    @PostMapping("/base/self/trade/query")
    public List<SelfTrade> querySelfTrade(){
        List<SelfTrade> selfTradeList = excelService.querySelfTrade();
        return selfTradeList;
    }
    @PostMapping("/base/trade/export")
    public void exportTrade(HttpServletResponse response)throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        List<SelfTrade> selfTradeList = excelService.querySelfTrade();
        String fileName = "自成交记录"  + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = { "资金账号", "成交价", "委托价", "成交日期", "成交时间", "买卖", "市场", "名称", "合约",
                "成交量", "手续费", "权利金", "市场日期", "市场时间", "交易所成交号", "委托合约", "合约类型",
                "成交来源", "订单类型", "委托号", "成交号", "系统号", "下单人", "币种", "流号", "开平", "平盈", "会员号", "T+1"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (SelfTrade selfTrade : selfTradeList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(selfTrade.getAccount());
            row1.createCell(1).setCellValue(selfTrade.getTradeprice().doubleValue());
            row1.createCell(2).setCellValue(selfTrade.getOrderprice().doubleValue());
            row1.createCell(3).setCellValue(selfTrade.getTradedate());
            row1.createCell(4).setCellValue(selfTrade.getTradetime());
            row1.createCell(5).setCellValue(selfTrade.getBuySell());
            row1.createCell(6).setCellValue(selfTrade.getExchange());
            row1.createCell(7).setCellValue(selfTrade.getName());
            row1.createCell(8).setCellValue(selfTrade.getContract());
            row1.createCell(9).setCellValue(Integer.parseInt(selfTrade.getTradecount()));
            row1.createCell(10).setCellValue(selfTrade.getFee());
            row1.createCell(11).setCellValue(selfTrade.getOptionfee());
            row1.createCell(12).setCellValue(selfTrade.getExchangedate());
            row1.createCell(13).setCellValue(selfTrade.getExchangetime());
            row1.createCell(14).setCellValue(selfTrade.getExchangetradenumber());
            row1.createCell(15).setCellValue(selfTrade.getOrdercontract());
            row1.createCell(16).setCellValue(selfTrade.getContracttype());
            row1.createCell(17).setCellValue(selfTrade.getTradesource());
            row1.createCell(18).setCellValue(selfTrade.getOrdertype());
            row1.createCell(19).setCellValue(selfTrade.getOrdernumber());
            row1.createCell(20).setCellValue(selfTrade.getTradenumber());
            row1.createCell(21).setCellValue(selfTrade.getSystemnumber());
            row1.createCell(22).setCellValue(selfTrade.getOrderuser());
            row1.createCell(23).setCellValue(selfTrade.getCurrency());
            row1.createCell(24).setCellValue(selfTrade.getStreamnumber());
            row1.createCell(25).setCellValue(selfTrade.getOpenclose());
            row1.createCell(26).setCellValue(selfTrade.getCloseprofit());
            row1.createCell(27).setCellValue(selfTrade.getUsernumber());
            row1.createCell(28).setCellValue(selfTrade.getTdata());
            rowNum++;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename="  + URLEncoder.encode(fileName, "UTF-8"));
        //response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"),"ISO-8859-1"));
        //response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
    /**
     *
     * @param multipartFile
     */
    @PostMapping("/base/trade/import")
    public Integer importTrade(@RequestParam(value="updatefile")MultipartFile multipartFile) {
        try{
            Long start = System.currentTimeMillis();
            ExcelParser parse = excelParser.parse(multipartFile.getInputStream());
            List<String[]> datas = parse.getDatas();
            /*List<SelfTrade> selfTradeList = new ArrayList<>();
            datas.forEach(w->{
                SelfTrade selfTrade = new SelfTrade();
                selfTrade.setAccount(w[0].trim());
                selfTrade.setExchange(w[1].trim());
                selfTrade.setName(w[2].trim());
                selfTrade.setContract(w[3].trim());
                selfTrade.setBuySell(w[4].trim());
                selfTrade.setTradeprice(new BigDecimal(w[5].trim()));
                selfTrade.setOrderprice(new BigDecimal(w[6].trim()));
                selfTrade.setTradecount(w[7].trim());
                selfTrade.setFee(w[8].trim());
                selfTrade.setOptionfee(w[9].trim());
                selfTrade.setExchangedate(w[10].trim());
                selfTrade.setExchangetime(w[11].trim());
                selfTrade.setExchangetradenumber(w[12].trim());
                selfTrade.setTradedate(w[13].trim());
                selfTrade.setTradetime(w[14].trim());
                selfTrade.setOrdercontract(w[15].trim());
                selfTrade.setContracttype(w[16].trim());
                selfTrade.setTradesource(w[17].trim());
                selfTrade.setOrdertype(w[18].trim());
                selfTrade.setOrdernumber(w[19].trim());
                selfTrade.setTradenumber(w[20].trim());
                selfTrade.setSystemnumber(w[21].trim());
                selfTrade.setOrderuser(w[22].trim());
                selfTrade.setCurrency(w[23].trim());
                selfTrade.setStreamnumber(w[24].trim());
                selfTrade.setOpenclose(w[25].trim());
                selfTrade.setCloseprofit(w[26].trim());
                selfTrade.setUsernumber(w[27].trim());
                selfTrade.setTdata(w[28].trim());
                selfTradeList.add(selfTrade);
            });*/
            Long excelEnd = System.currentTimeMillis();
            System.out.println("Excel执行时间："+(excelEnd-start));
            excelService.importTrade(datas);
            Long end = System.currentTimeMillis();
            System.out.println("总的执行时间："+(end-start));
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
