package Chapter4_TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ashis on 1/16/2017.
 */
public class BuildOrder {

    private Map<String, Project> projectMap = new HashMap<>();

    public String[] generateBuildOrder(String[][] dependencies) {

        buildDependencyGraph(dependencies);
        Project currProject = getBuildableProject();

        String[] order = new String[projectMap.size()];
        int iterator = 0;

        while(currProject != null && iterator != projectMap.size()) {
            order[iterator] = currProject.name;
            currProject.dependencies = Integer.MAX_VALUE;
            for(Project p : currProject.next) {
                --p.dependencies;
            }
            currProject = getBuildableProject();
        }

        return iterator == projectMap.size() ? order : null;
    }

    private void buildDependencyGraph(String[][] dependencies) {
        for(String[] dependency : dependencies) {
            String start = dependency[0];
            String end = dependency[1];

            Project startProject = getOrInsertProject(start);
            Project endProject = getOrInsertProject(end);

            startProject.next.add(endProject);
            ++endProject.dependencies;
        }
    }

    private Project getBuildableProject() {
        for(Project p : projectMap.values()) {
            if(p.dependencies == 0) {
                return p;
            }
        }

        return null;
    }

    private Project getOrInsertProject(String name) {
        if(!projectMap.containsKey(name)) {
            projectMap.put(name, new Project(name));
        }

        return projectMap.get(name);
    }

    private class Project {

        String name;
        List<Project> next = new ArrayList<>();
        int dependencies;

        Project(String name) {
            this.name = name;
        }
    }
}
