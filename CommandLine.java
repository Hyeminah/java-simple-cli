Public class CommandLine {

        private String commandName;
        private String argument;

    public CommandLine(String command){
        String[] commandArgs = command.split(" ",2);
        this.commandName = commandArgs[0];
        this.argument = (commandArgs.length>1) ? commandArgs[1]: null ;

    }

     public String getCommandName(){
        return commandName;
     }

     public String getArguments(){
        return argument;
     }

     public boolean hasArgument(){
        return argument != null;
     }


}
