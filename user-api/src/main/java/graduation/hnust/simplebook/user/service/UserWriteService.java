package graduation.hnust.simplebook.user.service;


import graduation.hnust.simplebook.user.dto.UserDto;
import graduation.hnust.simplebook.user.model.User;
import io.terminus.pampas.common.Response;

/**
 * 用户信息写服务
 *
 * @Author : panxin
 * @Date : 1:46 PM 3/20/16
 * @Email : panxin109@gmail.com
 */
public interface UserWriteService {

    /**
     * 创建用户
     *
     * @param user 用户信息
     * @return 用户ID
     */
    Response<Long> create(User user);

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return result
     */
    Response<Boolean> update(User user);

    /**
     * 删除用户信息
     *
     * @param id 用户ID
     * @return result
     */
    Response<Boolean> deleteById(Long id);

    /**
     * 创建用户
     *
     * @param userDto 用户DTO
     * @return 用户ID
     */
    Response<Long> create(UserDto userDto);
}
