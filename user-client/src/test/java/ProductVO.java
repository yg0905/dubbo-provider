import lombok.Data;

@Data
public class ProductVO {

    /**
     * 父类id
     */
    private Long parentId;

    /**
     * 名称
     */
    private String name;
    private String firstName;

    private String secondName;

    private String threeName;

    /**
     * 类型
     */
    private Integer type;

    /**
     * id
     */
    private Long id;

    /**
     * txy value
     */
    private String eocValue;

    public enum Type {
        /**
         * 一级
         */
        first(1),

        /**
         * 二级
         */
        second(2),

        /**
         * 三级
         */
        three(3),

        /**
         * txy
         */
        txy(0);

        private Integer code;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        Type(Integer code) {
            this.code = code;
        }

        public static String getType(int code) {
            for (Type type : Type.values()) {
                if (type.code.compareTo(code) == 0) {
                    return type.name();
                }
            }
            return null;
        }

    }


}
