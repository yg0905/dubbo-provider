import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.list.TreeList;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

@Slf4j
public class JsonTest {


    public static void main(String args[]) {

        String str = "{\n" +
                "   \"基本特性\": {\n" +
                "       \"类型及状态\":{\n" +
                "         \"目标名称\": \"xxx型号\",\n" +
                "         \"目标类型\": \"巡航导弹\",\n" +
                "         \"目标图像资料\": \"jiben/DD1.png\",\n" +
                "         \"装备概况\": \"jiben/1.txt\",\n" +
                "         \"战技性能\": \"jiben/2.txt\",\n" +
                "         \"导引头性能\": \"jiben/3.txt\",\n" +
                "         \"子目标\": \"jiben/4.txt\"\n" +
                "       },\n" +
                "     \"结构与动力学特性\": {\n" +
                "        \"几何参数\": {\n" +
                "          \"三维模型\":\"models/1.txt\",\n" +
                "          \"网络模型\":\"models/2.txt\",\n" +
                "          \"外形尺寸\":\"models/3.txt\"\n" +
                "        },\n" +
                "        \"质量参数\": {\n" +
                "          \"起飞质量\":\"20000.0\",\n" +
                "          \"弹头质量\":\"1000.0\",\n" +
                "          \"发动机质量\":\"5000.0\",\n" +
                "          \"发动机质量比\":\"50.000\",\n" +
                "          \"转到惯量\":\"3000.0\"\n" +
                "       },\n" +
                "        \"发动机参数\": {\n" +
                "          \"发动机性能参数\":\"fdj/1.txt\",\n" +
                "          \"发动机结构参数\":\"fdj/2.txt\",\n" +
                "          \"发动机燃料参数\":\"fdj/3.txt\"\n" +
                "       }\n" +
                "     },\n" +
                "     \"材料特性\": {\n" +
                "       \"材料分布特性\": {\n" +
                "         \"材料分布\": \"meterial/1.txt\"\n" +
                "       },\n" +
                "       \"材料参数\": {\n" +
                "         \"材料名称\": \"xxx材料名称/代号\",\n" +
                "         \"力学参数\": \"meterial/2.txt\",\n" +
                "         \"热学参数\": \"meterial/3.txt\",\n" +
                "         \"光学参数\": \"meterial/4.txt\",\n" +
                "         \"电磁参数\": \"meterial/5.txt\"\n" +
                "       }\n" +
                "     },\n" +
                "     \"目标半生效应\": {\n" +
                "       \"流场\": \"mbbs/1.txt\",\n" +
                "       \"等离子体分布\": \"mbbs/2.txt\"\n" +
                "     }\n" +
                "   },\n" +
                "  \"运动特性\": {\n" +
                "    \"弹道特性\": {\n" +
                "      \"弹道\": \"dd2/1.txt\",\n" +
                "      \"质阻比\": \"800.000\"\n" +
                "    },\n" +
                "    \"微动特性\": {\n" +
                "      \"自旋周期\": \"40.0\",\n" +
                "      \"进动周期\": \"30.0\",\n" +
                "      \"章动角\": \"30.000\",\n" +
                "      \"章动周期\": \"25.0\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"散射辐射特性\": {\n" +
                "    \"电磁散射特性\": {\n" +
                "      \"动/静态RCS特性\": {\n" +
                "        \"点频单站RCS\": \"sanshefushe/diancisanshe/1.txt\",\n" +
                "        \"点频双站RCS\": \"sanshefushe/diancisanshe/2.txt\",\n" +
                "        \"扫频单站RCS\": \"sanshefushe/diancisanshe/3.txt\",\n" +
                "        \"扫频双站RCS\": \"sanshefushe/diancisanshe/4.txt\"\n" +
                "      },\n" +
                "      \"动/静态高分辨特性\": {\n" +
                "        \"一维图像\": \"sanshefushe/diancisanshe/5.txt\",\n" +
                "        \"二维图像\": \"sanshefushe/diancisanshe/6.txt\",\n" +
                "        \"三维图像\": \"sanshefushe/diancisanshe/7.txt\"\n" +
                "      },\n" +
                "      \"动/静态角闪烁偏差特性\": {\n" +
                "        \"点频角闪烁偏差\": \"sanshefushe/diancisanshe/8.txt\",\n" +
                "        \"高分辨角闪烁偏差\": \"sanshefushe/diancisanshe/9.txt\"\n" +
                "      },\n" +
                "      \"多普勒特性\": {\n" +
                "        \"时间-多普勒普密度\": \"sanshefushe/diancisanshe/10.txt\",\n" +
                "        \"微多普勒密度\": \"sanshefushe/diancisanshe/11.txt\"\n" +
                "      },\n" +
                "      \"极化散射矩阵特性\": {\n" +
                "        \"点频极化矩阵\": \"sanshefushe/diancisanshe/12.txt\",\n" +
                "        \"扫频极化矩阵\": \"sanshefushe/diancisanshe/13.txt\"\n" +
                "      },\n" +
                "      \"近场特性\": {\n" +
                "        \"点频单站近场雷达散射截面\": \"sanshefushe/diancisanshe/14.txt\",\n" +
                "        \"近场回波\": \"sanshefushe/diancisanshe/15.txt\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"电子设备辐射特性\": {\n" +
                "      \"雷达辐射源\": \"sanshefushe/dzshebeifushe/1.txt\",\n" +
                "      \"通信信号\": \"sanshefushe/dzshebeifushe/2.txt\"\n" +
                "    },\n" +
                "    \"光学散射辐射特性\": {\n" +
                "      \"紫外特性\": {\n" +
                "        \"辐射亮度\": \"600.0\",\n" +
                "        \"辐射强度\": \"1000.0\"\n" +
                "      },\n" +
                "      \"激光散射特性\": {\n" +
                "        \"激光雷达散射截面\": \"88.0\",\n" +
                "        \"激光一维距离像\": \"sanshefushe/gxsanshefushe/1.txt\",\n" +
                "        \"激光二维图像\": \"sanshefushe/gxsanshefushe/2.txt\",\n" +
                "        \"近场等效散射截面\": \"500.0\"\n" +
                "      },\n" +
                "      \"红外特性\": {\n" +
                "        \"光谱辐射亮度\": \"1000.0\",\n" +
                "        \"光谱辐射强度\": \"10000.0\",\n" +
                "        \"辐射亮度\": \"6000.0\",\n" +
                "        \"辐射强度\": \"525.5\",\n" +
                "        \"红外偏振特性\": \"sanshefushe/gxsanshefushe/3.txt\",\n" +
                "        \"红外图像\": \"sanshefushe/gxsanshefushe/4.txt\"\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"易损特性\": {\n" +
                "    \"功能与结构特性\": {\n" +
                "      \"毁伤树\": \"yisun/1.txt\",\n" +
                "      \"易损性等效模型\": \"yisun/2.txt\"\n" +
                "    },\n" +
                "    \"损伤判据\": {\n" +
                "      \"损伤判据集\": \"yisun/3.txt\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"对抗特性\": {\n" +
                "    \"无源干扰特性\": {\n" +
                "      \"箔条\": {\n" +
                "        \"型号\": \"duikang/wygr/bt/1.txt\",\n" +
                "        \"使用方式\": \"duikang/wygr/bt/2.txt\",\n" +
                "        \"箔条参数\": \"duikang/wygr/bt/3.txt\",\n" +
                "        \"散射特性\": \"duikang/wygr/bt/4.txt\"\n" +
                "      },\n" +
                "      \"诱饵\": {\n" +
                "        \"型号\": \"duikang/wygr/yr/1.txt\",\n" +
                "        \"使用方式\": \"duikang/wygr/yr/2.txt\",\n" +
                "        \"诱饵参数\": \"duikang/wygr/yr/3.txt\",\n" +
                "        \"特性\": \"duikang/wygr/yr/4.txt\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"有源干扰特性\": {\n" +
                "      \"电子干扰机\": {\n" +
                "        \"型号\": \"duikang/yygr/dzgrj/1.txt\",\n" +
                "        \"使用方式\": \"duikang/yygr/dzgrj/2.txt\",\n" +
                "        \"干扰参数\": \"duikang/yygr/dzgrj/3.txt\"\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}\n";
        JSONObject jsonObject = JSONObject.parseObject(str);
        List<ProductVO> list = new TreeList();
        List<ProductVO> jsonFormat = objcetList(jsonObject, 0, list, null, null, null);
        System.out.println("返回的集合为： " + JSON.toJSONString(jsonFormat));
    }

    public static List<ProductVO> jsonFormat(JSONObject str,int i,List<ProductVO> list,Long firstId,Long secondId,Long threeId){
        Map<String,Object> map = str;
        i++;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            try {
                JSONObject parseObject = JSONObject.parseObject(String.valueOf(value));
                ProductVO vo = new ProductVO();
                //System.out.println("我是 "+ i +" TX: " + entry.getKey());
                vo.setName(entry.getKey());
                vo.setType(i);
                if(1 == i){
                    vo.setParentId(-1L);
                    vo.setId(Long.valueOf(SnowflakeIdWorker.generateId("")));
                    firstId = vo.getId();
                }else if(2 == i){
                    vo.setId(Long.valueOf(SnowflakeIdWorker.generateId("")));
                    vo.setParentId(firstId);
                    secondId = vo.getId();
                }else if(3 == i){
                    vo.setId(Long.valueOf(SnowflakeIdWorker.generateId("")));
                    vo.setParentId(secondId);
                    threeId = vo.getId();
                }else {
                    // 数据结构有问题
                    log.error("数据结构有问题，层级不对");
                    continue;
                }
                list.add(vo);
                jsonFormat(parseObject,i,list,firstId,secondId,threeId);
            }catch (Exception e){
                ProductVO vo = new ProductVO();
                //System.err.println("我是TXY的key ： " + entry.getKey() + " ; value: " + entry.getValue());
                if(null == threeId){
                    vo.setParentId(secondId);
                }else {
                    vo.setParentId(threeId);
                }
                vo.setId(Long.valueOf(SnowflakeIdWorker.generateId("")));
                vo.setName(entry.getKey());
                vo.setEocValue(String.valueOf(value));
                vo.setType(ProductVO.Type.txy.getCode());
                list.add(vo);
                i=1;
            }
        }
        return list;
    }

    /*public static boolean getJSONType(String str) {
        boolean result = false;
        if (StringUtils.isNotBlank(str)) {
            str = str.trim();
            if (str.startsWith("{") && str.endsWith("}")) {
                result = true;
            } else if (str.startsWith("[") && str.endsWith("]")) {
                result = true;
            }
        }
        return result;
    }*/
    public static List<ProductVO> objcetList(JSONObject str,int i,List<ProductVO> list,String firstName,String secondName,String threeName){
        Map<String,Object> map = str;
        i++;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            try {
                JSONObject parseObject = JSONObject.parseObject(String.valueOf(value));
                ProductVO vo = new ProductVO();
                //System.out.println("我是 "+ i +" TX: " + entry.getKey());
                vo.setName(entry.getKey());
                vo.setType(i);
                if(1 == i){
                    firstName = entry.getKey();
                }else if(2 == i){
                    secondName = entry.getKey();
                }else if(3 == i){
                    threeName = entry.getKey();
                }else {
                    // 数据结构有问题
                    log.error("数据结构有问题，层级不对");
                    continue;
                }
                objcetList(parseObject,i,list,firstName,secondName,threeName);
            }catch (Exception e){
                ProductVO vo = new ProductVO();
                //System.err.println("我是TXY的key ： " + entry.getKey() + " ; value: " + entry.getValue());
                if(StringUtils.isBlank(threeName)){
                    vo.setFirstName(firstName);
                    vo.setSecondName(secondName);
                }else {
                    vo.setFirstName(firstName);
                    vo.setSecondName(secondName);
                    vo.setThreeName(threeName);
                }
                vo.setId(Long.valueOf(SnowflakeIdWorker.generateId("")));
                vo.setName(entry.getKey());
                vo.setEocValue(String.valueOf(value));
                vo.setType(ProductVO.Type.txy.getCode());
                list.add(vo);
                i=1;
            }
        }
        return list;
    }
}