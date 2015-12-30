#!/usr/bin/env ruby

require 'xcodeproj'

project_file = Dir.glob("platforms/ios/*.xcodeproj")[0]
target_name = File.basename(project_file, ".xcodeproj")

project = Xcodeproj::Project.open(project_file)
target = project.targets.select { |t| t.name == target_name }

project.build_configurations.each { |config|
	# for server-side symolication
  config.build_settings['COPY_PHASE_STRIP'] = 'YES'
  config.build_settings['STRIP_INSTALLED_PRODUCT'] = 'YES'
  config.build_settings['ENABLE_BITCODE'] = 'NO'

  # ensure these are set
  flags = config.build_settings['OTHER_LDFLAGS']
  flags.push '-ObjC' unless flags.include? '-ObjC'
  flags.push '-all_load' unless flags.include? '-all_load'
}

project.save

