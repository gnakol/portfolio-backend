import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllExperienceComponent } from './components/experiences-package/web-service/all-experience/all-experience.component';
import { AllTrainingsComponent } from './components/training-package/web-services/all-trainings/all-trainings.component';
import { AllSkillComponent } from './components/skill-package/web-service/all-skill/all-skill.component';
import { AllProjectsComponent } from './components/project-package/web-service/all-project/all-project.component';
import { AllHobbiesComponent } from './components/hobbies-package/web-service/all-hobbies/all-hobbies.component';
import { AllLanguagesComponent } from './components/language-package/web-service/all-languages/all-languages.component';
import { AuthComponent } from './pages/authenticate/auth/auth.component';
import { AddExperienceComponent } from './components/experiences-package/web-service/add-experience/add-experience.component';
import { AddTrainingsComponent } from './components/training-package/web-services/add-trainings/add-trainings.component';
import { AddSkillComponent } from './components/skill-package/web-service/add-skill/add-skill.component';
import { AddHobbiesComponent } from './components/hobbies-package/web-service/add-hobbies/add-hobbies.component';
import { AddLanguagesComponent } from './components/language-package/web-service/add-languages/add-languages.component';
import { ExperienceTemplateComponent } from './components/experiences-package/experience-template/experience-template.component';
import { SkillTemplateComponent } from './components/skill-package/skill-template/skill-template.component';
import { TrainingTemplateComponent } from './components/training-package/training-template/training-template.component';
import { HobbieTemplateComponent } from './components/hobbies-package/hobbie-template/hobbie-template.component';
import { LanguageTemplateComponent } from './components/language-package/language-template/language-template.component';
import { DashboardComponent } from './components/admin-dashboard-package/dashboard-admin/dashboard.component';
import { AllEstablishmentComponent } from './components/establishment-package/web-service/all-establishment/all-establishment.component';
import { AddEstablishmentComponent } from './components/establishment-package/web-service/add-establishment/add-establishment.component';
import { AllSkillCategoryComponent } from './components/skill-package/web-service/all-skill-category/all-skill-category.component';
import { AddSkillCategoryComponent } from './components/skill-package/web-service/add-skill-category/add-skill-category.component';
import { PdfGeneratorComponent } from './components/pdf-generator-package/pdf-generator/pdf-generator.component';
import { SimulationDashboardComponent } from './components/simulation-package/simulation-dashboard/simulation-dashboard.component';
import { PingSimulationsComponent } from './components/simulation-package/ping-simulations/ping-simulations.component';
import { NetworkSimulationComponent } from './components/simulation-package/network-simulation/network-simulation.component';
import { VlanSimulationComponent } from './components/simulation-package/network-simulation/vlan-simulation/vlan-simulation.component';
import { IntroComponent } from './components/simulation-package/network-simulation/vlan-simulation/intro/intro.component';
import { TerminalComponent } from './components/simulation-package/network-simulation/vlan-simulation/terminal/terminal.component';
import { AllLogSecurityComponent } from './components/log-security-package/web-services/all-log-security/all-log-security.component';
import { IntroEigrpComponent } from './components/simulation-package/network-simulation/eigrp-simulation/intro/intro.component';
import { EigrpSimulationComponent } from './components/simulation-package/network-simulation/eigrp-simulation/eigrp-simulation.component';
import { TerminalEigrpComponent } from './components/simulation-package/network-simulation/eigrp-simulation/terminal-eigrp/terminal-eigrp.component';

const routes: Routes = [
  { path: '', loadChildren: () => import('./pages/home/home.module').then(m => m.HomeModule) },
  { path: 'cv', loadChildren: () => import('./pages/cv/cv.module').then(m => m.CvModule) },
  { path: 'simulations', loadChildren: () => import('./pages/simulations/simulations.module').then(m => m.SimulationsModule) },
  { path: 'blog', loadChildren: () => import('./pages/blog/blog.module').then(m => m.BlogModule) },
  { path: 'contact', loadChildren: () => import('./pages/contact/contact.module').then(m => m.ContactModule) },
  { path: 'admin-dashboard', loadChildren: () => import('./components/admin-dashboard-package/admin/admin.module').then(m => m.AdminModule)},

  // 🔥 Nouvelle route pour afficher les expériences
  { path: 'experiences', component: AllExperienceComponent },

  { path: 'trainings', component: AllTrainingsComponent },
  { path: 'skills', component: AllSkillComponent},
  { path: 'projects', component: AllProjectsComponent},
  { path: 'hobbies', component: AllHobbiesComponent},
  { path: 'languages', component : AllLanguagesComponent},
  { path: 'all-establishment', component : AllEstablishmentComponent},
  { path: 'all-skill-category', component : AllSkillCategoryComponent},
  { path: 'all-log-security', component : AllLogSecurityComponent},




  { path: 'login', component : AuthComponent},
  { path: 'dashboard-admin', component : DashboardComponent},
  { path: 'dashboard-simulation', component : SimulationDashboardComponent},
  { path: 'network-simulation', component : NetworkSimulationComponent},
  { path: 'vlan-simulation', component : VlanSimulationComponent},
  { path: 'eigrp-simulation', component : EigrpSimulationComponent},



  { path: 'add-training', component : AddTrainingsComponent},
  { path: 'add-skill', component : AddSkillComponent},
  { path: 'add-hobbie', component : AddHobbiesComponent},
  { path: 'add-language', component : AddLanguagesComponent}, 
  { path: 'add-establishment', component : AddEstablishmentComponent},
  { path: 'add-skill-category', component : AddSkillCategoryComponent},

  { path: 'experience-template', component : ExperienceTemplateComponent},
  { path: 'skill-template', component : SkillTemplateComponent},
  { path: 'training-template', component : TrainingTemplateComponent},
  { path: 'hobbie-template', component : HobbieTemplateComponent},
  { path: 'language-template', component : LanguageTemplateComponent},

  { path: 'pdf-generator', component : PdfGeneratorComponent},

  // Simulation

  {path: 'ping-simulation', component : PingSimulationsComponent},



  // For vlan
  { path : 'intro-vlan', component : IntroComponent},
  { path : 'terminal-vlan-config', component : TerminalComponent},

  // For eigrp
  { path : 'terminal-eigrp-config', component : TerminalEigrpComponent},
  { path : 'intro-eigrp', component : IntroEigrpComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
