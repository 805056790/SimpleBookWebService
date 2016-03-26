package graduation.hnust.simplebook.book.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 消费类型
 *
 * @Author : panxin
 * @Date : 8:52 PM 3/22/16
 * @Email : panxin109@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumeType implements Serializable{

    private static final long serialVersionUID = -692293738416385807L;

    /**
     * ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 图片
     */
    private String image;

    private Date createdAt;

    private Date updatedAt;

}
