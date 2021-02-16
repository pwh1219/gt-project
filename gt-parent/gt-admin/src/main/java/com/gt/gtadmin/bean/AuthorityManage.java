package com.gt.gtadmin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 权限管理
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AuthorityManage对象", description="权限管理")
public class AuthorityManage implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "authority_id", type = IdType.AUTO)
    private Integer authorityId;

    @ApiModelProperty(value = "权限名称")
    private String authorityName;

    @ApiModelProperty(value = "权限访问url地址")
    private String authorityUrl;

    @ApiModelProperty(value = "权限编码")
    private String authorityCode;

    @ApiModelProperty(value = "目录类型:1表示菜单,2表示按钮")
    private String authorityType;

    @ApiModelProperty(value = "状态:0表示禁用,1表示可用")
    private String authorityStatus;

    @ApiModelProperty(value = "排序")
    private Integer authoritySort;

    @ApiModelProperty(value = "0表示为根目录,其它表示父目录id")
    private Integer fatherId;

    @ApiModelProperty(value = "0表示未删除,1表示删除")
    private String authorityDelete;


}
