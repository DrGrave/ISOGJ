import {MyUser} from "./MyUser";
import {Education} from "./Education";
import {UserSkill} from "../user-list-page/userSkill";
import {UserCompany} from "./UserCompany";
import {UserLink} from "./UserLink";

export class FullUserInfo{
  meUserDto: MyUser;
  educationDtoList: Education[];
  userSkillDtoList: UserSkill[];
  userCompanyDtoList: UserCompany[];
  userLinkDtoList: UserLink[];
  userLinkDto: UserLink;
}
