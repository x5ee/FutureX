package Method.Client.module.command;

import Method.Client.utils.LoginUtils;
import Method.Client.utils.system.Wrapper;
import Method.Client.utils.visual.ChatUtils;

public class Login extends Command {
   public Login() {
      super("login");
   }

   public void runCommand(String s, String[] args) {
      try {
         if (args.length <= 1 && !args[0].contains(":")) {
            LoginUtils.changeCrackedName(args[0]);
            ChatUtils.warning("Logged [Cracked]: " + Wrapper.INSTANCE.mc().func_110432_I().func_111285_a());
         } else {
            String email;
            String password;
            if (args[0].contains(":")) {
               String[] split = args[0].split(":", 2);
               email = split[0];
               password = split[1];
            } else {
               email = args[0];
               password = args[1];
            }

            String log = LoginUtils.loginAlt(email, password);
            ChatUtils.warning(log);
         }
      } catch (Exception var6) {
         ChatUtils.error("Usage: " + this.getSyntax());
      }

   }

   public String getDescription() {
      return "Change session.";
   }

   public String getSyntax() {
      return "login <email> <password>/<nick>";
   }
}
