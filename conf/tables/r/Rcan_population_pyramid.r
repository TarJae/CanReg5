  ## To get the R folder of the actual script
  initial.options <- commandArgs(trailingOnly = FALSE)
  file.arg.name <- "--file="
  script.name <- sub(file.arg.name, "", 
                     initial.options[grep(file.arg.name, initial.options)])
  script.basename <- dirname(script.name)
  
  ## Load Rcan function
  source(paste(sep="/", script.basename, "Rcan_core.r"))
  
  ## to get canreg argument list
  Args <- commandArgs(TRUE)
  ls_args <- canreg_args(Args)
  
  
tryCatch({
  
  #load dependency packages
	canreg_load_packages(c("data.table", "ggplot2", "gridExtra", "scales", "Cairo","bmp", "jpeg", "shiny.i18n", "Rcan"))
	i18n <- Translator(translation_csvs_path  = (paste(sep="/", script.basename, "r-translations")))
	i18n$set_translation_language(ls_args$lang)
	
	
	
  #Prepare canreg data population pyramid
  dt_all <- canreg_pop_data(pop_file =ls_args$pop)

	##Produce output
  canreg_output(output_type = ls_args$ft, filename = ls_args$out,landscape = ls_args$landscape,list_graph = FALSE,
                FUN=canreg_population_pyramid,
                df_data=dt_all,
                canreg_header = ls_args$header)

  #talk to canreg
  canreg_output_cat(ls_args$ft, ls_args$filename)
  
  
  	},
  
  error = function(e){
    if (dev.cur() > 1) {
      dev.off()
	  temp_file <- substr(ls_args$filename,0,nchar(ls_args$filename)-nchar(ls_args$ft)-1)
      if (file.exists(ls_args$filename)) file.remove(ls_args$filename)
	  if (file.exists(paste0(temp_file,"001.",ls_args$ft))) file.remove(paste0(temp_file,"001.",ls_args$ft))
	  if (file.exists(paste0(temp_file,"002.",ls_args$ft))) file.remove(paste0(temp_file,"002.",ls_args$ft))
    }
    
    canreg_error_log(e,ls_args$filename,ls_args$out,Args,ls_args$inc,ls_args$pop)
  }
)
	
	
