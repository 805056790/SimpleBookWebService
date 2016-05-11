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

    private Long id;
    private Long userId;
    // private String userName;
    private Long bookId;
    private Integer type;
    private Integer status;
    private String image;
    private Integer imageId;
    private Date date;
    private String note;
    private Integer consumeType;
    private String consumeTypeName;
    private Integer amount;
    private String longitude;
    private String latitude;
    private Date createdAt;
    private Date updatedAt;
}
