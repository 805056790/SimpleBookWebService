package graduation.hnust.simplebook.book.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 账目信息
 *
 * @Author : panxin
 * @Date : 8:25 PM 3/22/16
 * @Email : panxin109@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable{

    private static final long serialVersionUID = 7699950340510681455L;

    /**
     * ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 账本ID
     */
    private Long bookId;

    /**
     * 收支类型 1:收入  -1:支出
     */
    private Integer type;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 图片
     */
    private String image;

    /**
     * 记账日期
     */
    private Date date;

    /**
     * 备注
     */
    private String note;

    /**
     * 消费类型
     */
    private Integer consumeType;

    /**
     * 消费金额
     */
    private Integer amount;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    private Date createdAt;

    private Date updatedAt;

}
