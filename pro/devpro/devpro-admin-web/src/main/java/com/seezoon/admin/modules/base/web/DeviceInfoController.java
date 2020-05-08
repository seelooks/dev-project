package com.seezoon.admin.modules.base.web;

import java.io.Serializable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.seezoon.boot.common.web.BaseController;
import com.seezoon.boot.context.dto.ResponeModel;
import com.seezoon.service.modules.base.entity.DeviceInfo;
import com.seezoon.service.modules.base.service.DeviceInfoService;

/**
 * 设备信息controller
 * Copyright &copy; 2018 powered by huangdf, All rights reserved.
 * @author hdf 2019-3-27 21:07:56
 */
@RestController
@RequestMapping("${admin.path}/base/deviceInfo")
@Api(description = "设备管理")
public class DeviceInfoController extends BaseController {

	@Autowired
	private DeviceInfoService deviceInfoService;

	@ApiOperation(value = "获取列表", notes = "根据传入对象获取")
	@PreAuthorize("hasAuthority('base:deviceInfo:qry')")
	@PostMapping("/qryPage.do")
	public ResponeModel qryPage(DeviceInfo deviceInfo) {
		PageInfo<DeviceInfo> page = deviceInfoService.findByPage(deviceInfo, deviceInfo.getPage(), deviceInfo.getPageSize());
		return ResponeModel.ok(page);
	}


	@GetMapping("/qryPage2.do")
	public ResponeModel qryPage() {
		DeviceInfo deviceInfo = new DeviceInfo();
		PageInfo<DeviceInfo> page = deviceInfoService.findByPage(deviceInfo, deviceInfo.getPage(), deviceInfo.getPageSize());
		return ResponeModel.ok(page);
	}


	@PreAuthorize("hasAuthority('base:deviceInfo:qry')")
	@RequestMapping("/get.do")
	public ResponeModel get(@RequestParam Integer id) {
		DeviceInfo deviceInfo = deviceInfoService.findById(id);
		return ResponeModel.ok(deviceInfo);
	}
	@PreAuthorize("hasAuthority('base:deviceInfo:save')")
	@PostMapping("/save.do")
	public ResponeModel save(@Validated DeviceInfo deviceInfo, BindingResult bindingResult) {
		int cnt = deviceInfoService.save(deviceInfo);
		return ResponeModel.ok(cnt);
	}
	@PreAuthorize("hasAuthority('base:deviceInfo:qry')")
	@PostMapping("/update.do")
	public ResponeModel update(@Validated DeviceInfo deviceInfo, BindingResult bindingResult) {
		int cnt = deviceInfoService.updateSelective(deviceInfo);
		return ResponeModel.ok(cnt);
	}
	@PreAuthorize("hasAuthority('base:deviceInfo:delete')")
	@PostMapping("/delete.do")
	public ResponeModel delete(@RequestParam Serializable id) {
		int cnt = deviceInfoService.deleteById(id);
		return ResponeModel.ok(cnt);
	}
}
