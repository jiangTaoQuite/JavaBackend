package tech.jiangtao.springmvc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tech.jiangtao.springmvc.model.Orderdetail;
import tech.jiangtao.springmvc.model.OrderdetailExample;

public interface OrderdetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Sun Mar 26 02:27:42 CST 2017
     */
    int countByExample(OrderdetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Sun Mar 26 02:27:42 CST 2017
     */
    int deleteByExample(OrderdetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Sun Mar 26 02:27:42 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Sun Mar 26 02:27:42 CST 2017
     */
    int insert(Orderdetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Sun Mar 26 02:27:42 CST 2017
     */
    int insertSelective(Orderdetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Sun Mar 26 02:27:42 CST 2017
     */
    List<Orderdetail> selectByExample(OrderdetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Sun Mar 26 02:27:42 CST 2017
     */
    Orderdetail selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Sun Mar 26 02:27:42 CST 2017
     */
    int updateByExampleSelective(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Sun Mar 26 02:27:42 CST 2017
     */
    int updateByExample(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Sun Mar 26 02:27:42 CST 2017
     */
    int updateByPrimaryKeySelective(Orderdetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Sun Mar 26 02:27:42 CST 2017
     */
    int updateByPrimaryKey(Orderdetail record);
}