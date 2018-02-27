import {User} from "./user";
import {UserSkill} from "./userSkill";
import {EducationDto} from "./EducationDto";
import {UserLink} from "../home-page/UserLink";

export class UserListInfo{
  userDto: User;
  userSkills: UserSkill[];
  userLinkDto: UserLink;
  educations: EducationDto[];
}
