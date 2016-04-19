package graduation.hnust.simplebook.user.service;


import graduation.hnust.simplebook.user.enums.LoginType;
import graduation.hnust.simplebook.user.model.User;
import io.terminus.pampas.common.Response;


/**
 * 用户信息读服务
 *
 * @Author : panxin
 * @Date : 1:46 PM 3/20/16
 * @Email : panxin109@gmail.com
 */
public interface UserReadService {

    /**
     * 通过类型和账号查找
     *
     * @param loginType 登录类型
     * @param loginBy 账号
     * @return 结果
     */
    Response<User> findBy(LoginType loginType, String loginBy);

    /**
     * 通过ID 查找用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    Response<User> findById(Long id);

    /**
     * 通过QQToken查找用户信息
     *
     * @param qqToken qqToken
     * @return 用户信息
     */
    Response<User> findByQqToken(String qqToken);

    /**
     * 通过QQ openId 查找用户信息
     *
     * @param openId openId
     * @return 用户信息
     */
    Response<User> findByQqOpenId(String openId);

    /**
     * 用户登录, 现检测用户名是否已存在, 在判断密码是否相等
     *
     * @param loginBy 登录名
     * @param password 密码
     * @param loginType 登录类型
     * @return 用户信息
     */
    Response<User> login(String loginBy, String password, Integer loginType);

}
