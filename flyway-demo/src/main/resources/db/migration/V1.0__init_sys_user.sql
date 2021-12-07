-- 创建用户表
CREATE TABLE "public"."sys_user" (
  "id" int8 NOT NULL,
  "user_name" varchar(255),
  "pwd" varchar(255),
  "adder" varchar(255)
)
;

COMMENT ON COLUMN "public"."sys_user"."id" IS '主键';

COMMENT ON COLUMN "public"."sys_user"."user_name" IS '用户姓名';

COMMENT ON COLUMN "public"."sys_user"."pwd" IS '密码';

COMMENT ON COLUMN "public"."sys_user"."adder" IS '地址';