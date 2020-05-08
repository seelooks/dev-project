package com.seezoon.admin.modules.base.web;

import com.github.pagehelper.PageInfo;
import com.seezoon.boot.common.web.BaseController;
import com.seezoon.boot.context.dto.ResponeModel;
import com.seezoon.service.modules.base.entity.DeviceStaticInfo;
import com.seezoon.service.modules.base.service.DeviceStaticInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.UUID;


@SuppressWarnings("all")
@RestController
@RequestMapping("${admin.path}/base/deviceStaticInfo")
public class DeviceStaticInfoController extends BaseController {

    @Autowired
    private DeviceStaticInfoService deviceStaticInfoService;

    @PostMapping("/qryPage")
    public ResponeModel qryPage() {
        DeviceStaticInfo deviceInfoq = new DeviceStaticInfo();
        PageInfo<DeviceStaticInfo> page = deviceStaticInfoService.findByPage(deviceInfoq, deviceInfoq.getPage(), deviceInfoq.getPageSize());
        return ResponeModel.ok(page);
    }

    @RequestMapping("/get.do")
    public ResponeModel  get(@RequestParam Serializable id){
        DeviceStaticInfo deviceStaticInfo = deviceStaticInfoService.findById(id);
        return ResponeModel.ok(deviceStaticInfo);
    }

    //@PreAuthorize("hasAuthority('sys:loginlog:save')")
    @PostMapping("/save.do")
    public ResponeModel save(@Validated DeviceStaticInfo deviceStaticInfo, BindingResult bindingResult) {
        int cnt = deviceStaticInfoService.save(deviceStaticInfo);
        return ResponeModel.ok(cnt);
    }
   // @PreAuthorize("hasAuthority('sys:loginlog:update')")
    @PostMapping("/update.do")
    public ResponeModel update(@Validated DeviceStaticInfo deviceStaticInfo, BindingResult bindingResult) {
        int cnt = deviceStaticInfoService.updateSelective(deviceStaticInfo);
        return ResponeModel.ok(cnt);
    }

   // @PreAuthorize("hasAuthority('sys:loginlog:delete')")
    @PostMapping("/delete.do")
    public ResponeModel delete(@RequestParam Serializable id) {
        int cnt = deviceStaticInfoService.deleteById(id);
        return ResponeModel.ok(cnt);
    }


}
