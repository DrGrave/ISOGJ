import {MyUser} from "./MyUser";
import {UserSkill} from "../user-list-page/userSkill";
import {UserLink} from "./UserLink";
import {EducationSkillsDto} from "./EducationSkillsDto";
import {UserCompanySkills} from "./UserCompanySkills";
import {ExperienceSkills} from "./ExperienceSkills";
import {HistorySkills} from "./HistorySkills";
import {CoursesSkills} from "./CoursesSkills";

export class FullUserInfo{
  meUserDto: MyUser;
  userLinkDto: UserLink;
  educationSkillsDtoList: EducationSkillsDto[];
  userSkillDtoList: UserSkill[];
  userCompanySkillsDtoList: UserCompanySkills[];
  experienceSkillsDtoList: ExperienceSkills[];
  historySkillsDtoList: HistorySkills[];
  coursesSkillsListDtoList: CoursesSkills[];
}
